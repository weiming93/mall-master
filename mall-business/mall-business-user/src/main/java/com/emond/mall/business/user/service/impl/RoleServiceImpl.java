package com.emond.mall.business.user.service.impl;

import com.emond.mall.business.user.repository.RoleRepository;
import com.emond.mall.business.user.service.RoleService;
import com.emond.mall.common.exception.EntityExistException;
import com.emond.mall.provider.user.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Role create(Role role) {
        if(roleRepository.existsByName(role.getName())){
            throw new EntityExistException("角色",role.getName());
        }
        return roleRepository.save(role);
    }
}
