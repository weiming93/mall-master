package com.emond.mall.business.system.service.impl;


import com.emond.mall.business.system.domain.Role;
import com.emond.mall.business.system.domain.User;
import com.emond.mall.business.system.domain.query.UserQueryCriteria;
import com.emond.mall.business.system.repository.UserRepository;
import com.emond.mall.business.system.service.RoleService;
import com.emond.mall.business.system.service.UserService;
import com.emond.mall.common.exception.BadRequestException;
import com.emond.mall.common.exception.EntityExistException;
import com.emond.mall.common.exception.ResourceNotFoundException;
import com.emond.mall.common.utils.OAuth2Utils;
import com.emond.mall.common.utils.QueryHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleService roleService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User create(User resources) {
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

        return userRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<Long> ids) {
        for (Long id : ids) {
            checkLevel(id);
            userRepository.deleteById(id);
        }
    }

    /**
     * 如果当前用户的角色级别低于创建用户的角色级别，则抛出权限不足的错误
     *
     * @param userId 被操作用户ID
     */
    private void checkLevel(Long userId) {
        Integer currentLevel = Collections.min(roleService.findByUsersId(OAuth2Utils.getCurrentUserId()).stream().map(Role::getLevel).collect(Collectors.toList()));
        Integer optLevel = Collections.min(roleService.findByUsersId(userId).stream().map(Role::getLevel).collect(Collectors.toList()));
        if (currentLevel > optLevel) {
            throw new BadRequestException("角色权限不足，不能操作");
        }
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("用户", "ID", id));
        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(User resources) {
        Long userId = resources.getId();
        this.findById(userId);
        checkLevel(userId);
        if (userRepository.existsByUsernameAndIdNot(resources.getUsername(), userId)) {
            throw new EntityExistException("账号", resources.getUsername());
        }
        if (userRepository.existsByEmailAndIdNot(resources.getEmail(), userId)) {
            throw new EntityExistException("邮箱", resources.getEmail());
        }

        if (userRepository.existsByPhoneAndIdNot(resources.getPhone(), userId)) {
            throw new EntityExistException("电话", resources.getPhone());
        }
        userRepository.save(resources);
    }

    @Override
    public Page<User> getUserPage(UserQueryCriteria criteria, Pageable pageable) {

        return userRepository.findAll((root, criteriaQuery, criteriaBuilder)
                -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
    }


}
