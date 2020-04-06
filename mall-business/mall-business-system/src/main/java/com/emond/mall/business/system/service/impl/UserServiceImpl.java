package com.emond.mall.business.system.service.impl;


import com.emond.mall.business.system.domain.Role;
import com.emond.mall.business.system.domain.User;
import com.emond.mall.business.system.domain.UserAvatar;
import com.emond.mall.business.system.domain.UserProfile;
import com.emond.mall.business.system.repository.UserRepository;
import com.emond.mall.business.system.service.RoleService;
import com.emond.mall.business.system.service.UserService;
import com.emond.mall.common.exception.BadRequestException;
import com.emond.mall.common.exception.EntityExistException;
import com.emond.mall.common.service.impl.BaseServiceImpl;
import com.emond.mall.common.utils.OAuth2Utils;
import com.emond.mall.provider.system.dto.UserPassDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private final static String NAME = "角色";
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository, NAME);
        this.userRepository = userRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User create(User resources) {
        checkLevel(resources);
        if (userRepository.existsByUsername(resources.getUsername())) {
            throw new EntityExistException("账号", resources.getUsername());
        }
        if (userRepository.existsByEmail(resources.getEmail())) {
            throw new EntityExistException("邮箱", resources.getEmail());
        }

        if (userRepository.existsByPhone(resources.getEmail())) {
            throw new EntityExistException("电话", resources.getPhone());
        }
        resources.setPassword(passwordEncoder.encode("123456"));

        return super.create(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<Long> ids) {
        for (Long id : ids) {
            Integer currentLevel = Collections.min(roleService.findByUsersId(OAuth2Utils.getCurrentUserId()).stream().map(Role::getLevel).collect(Collectors.toList()));
            Integer optLevel = Collections.min(roleService.findByUsersId(id).stream().map(Role::getLevel).collect(Collectors.toList()));
            if (currentLevel > optLevel) {
                throw new BadRequestException("角色权限不足，不能操作");
            }
            userRepository.deleteById(id);
        }
    }

    /**
     * 如果当前用户的角色级别低于创建用户的角色级别，则抛出权限不足的错误
     *
     * @param resource 被操作用户
     */
    private void checkLevel(User resource) {
        Integer currentLevel = Collections.min(roleService.findByUsersId(OAuth2Utils.getCurrentUserId()).stream().map(Role::getLevel).collect(Collectors.toList()));
        Integer optLevel = Collections.min(resource.getRoles().stream().map(Role::getLevel).collect(Collectors.toList()));
        if (currentLevel > optLevel) {
            throw new BadRequestException("角色权限不足，不能操作");
        }
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public User update(User resources) {
        Long userId = resources.getId();
        checkLevel(resources);
        if (userRepository.existsByUsernameAndIdNot(resources.getUsername(), userId)) {
            throw new EntityExistException("账号", resources.getUsername());
        }
        if (userRepository.existsByEmailAndIdNot(resources.getEmail(), userId)) {
            throw new EntityExistException("邮箱", resources.getEmail());
        }

        if (userRepository.existsByPhoneAndIdNot(resources.getPhone(), userId)) {
            throw new EntityExistException("电话", resources.getPhone());
        }
        return super.update(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePass(UserPassDTO userPassDTO) {
        User currentUser = this.findById(OAuth2Utils.getCurrentUserId());
        if(!passwordEncoder.matches(userPassDTO.getOldPass(), currentUser.getPassword())){
            throw new BadRequestException("修改失败，旧密码错误");
        }
        if(passwordEncoder.matches(userPassDTO.getNewPass(), currentUser.getPassword())){
            throw new BadRequestException("新密码不能与旧密码相同");
        }

        currentUser.setPassword(passwordEncoder.encode(userPassDTO.getNewPass()));
        super.update(currentUser);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateProfile(UserProfile resource) {
        User user = new User();
        BeanUtils.copyProperties(resource,user);
        super.update(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAvatar(UserAvatar resource) {
        User user = new User();
        BeanUtils.copyProperties(resource,user);
        super.update(user);
    }
}
