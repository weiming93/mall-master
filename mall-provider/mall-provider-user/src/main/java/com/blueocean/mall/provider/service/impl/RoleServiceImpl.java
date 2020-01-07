package com.blueocean.mall.provider.service.impl;

import com.blueocean.mall.common.exception.EntityExistException;
import com.blueocean.mall.provider.domain.Role;
import com.blueocean.mall.provider.repository.RoleRepository;
import com.blueocean.mall.provider.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
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
