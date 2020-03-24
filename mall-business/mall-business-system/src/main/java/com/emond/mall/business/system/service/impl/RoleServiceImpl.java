package com.emond.mall.business.system.service.impl;

import com.emond.mall.business.system.domain.Role;
import com.emond.mall.business.system.domain.User;
import com.emond.mall.business.system.domain.query.RoleQueryCriteria;
import com.emond.mall.business.system.repository.RoleRepository;
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserService userService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Role create(Role resources) {
        getLevels(resources.getLevel());
        if(roleRepository.existsByName(resources.getName())){
            throw new EntityExistException("角色",resources.getName());
        }
        return roleRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<Long> ids) {
        for (Long id : ids) {
            Role role = this.findById(id);
            getLevels(role.getLevel());
            roleRepository.deleteById(id);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Role resources) {
        this.findById(resources.getId());
        if(roleRepository.existsByName(resources.getName())){
            throw new EntityExistException("角色",resources.getName());
        }
        getLevels(resources.getLevel());
        roleRepository.save(resources);
    }

    @Override
    public Role findById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("角色", "ID", id));
        return role;
    }

    @Override
    public List<Role> findByUsersId(Long id) {
        return roleRepository.findByUsersId(id);
    }

    @Override
    public Page<Role> getRolePage(RoleQueryCriteria criteria, Pageable pageable) {
        Page<Role> page = roleRepository.findAll((root, criteriaQuery, criteriaBuilder)
                -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return page;
    }

    /**
     * 获取用户的角色级别
     * @return /
     */
    @Override
    public Integer getLevels(Integer level){
        User user = userService.findById(OAuth2Utils.getCurrentUserId());
        List<Integer> levels = roleRepository.findByUsersId(user.getId()).stream().map(Role::getLevel).collect(Collectors.toList());
        int min = Collections.min(levels);
        if(level != null){
            if(level < min){
                throw new BadRequestException("权限不足，你的角色级别：" + min + "，低于操作的角色级别：" + level);
            }
        }
        return min;
    }

    @Override
    public void untiedMenu(Long id) {
        roleRepository.untiedMenu(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMenu(Role resources) {
        Role role = roleRepository.findById(resources.getId())
                .orElseThrow(() -> new ResourceNotFoundException("角色", "ID", resources.getId()));
        getLevels(role.getLevel());
        role.setMenus(resources.getMenus());
        roleRepository.save(role);
    }

    @Override
    public List<Role> findAll(Pageable pageable) {
        return roleRepository.findAll(pageable).getContent();
    }
}
