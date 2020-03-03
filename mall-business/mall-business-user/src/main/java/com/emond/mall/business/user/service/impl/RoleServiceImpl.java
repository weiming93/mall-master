package com.emond.mall.business.user.service.impl;

import com.emond.mall.business.user.mapper.RoleMapper;
import com.emond.mall.business.user.repository.RoleRepository;
import com.emond.mall.business.user.service.RoleService;
import com.emond.mall.common.exception.EntityExistException;
import com.emond.mall.common.exception.ResourceNotFoundException;
import com.emond.mall.provider.user.domain.Role;
import com.emond.mall.provider.user.dto.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Role create(Role role) {
        if(roleRepository.existsByName(role.getName())){
            throw new EntityExistException("角色",role.getName());
        }
        return roleRepository.save(role);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Role role) {
        this.findById(role.getId());
        roleRepository.save(role);
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("角色","ID",id));
    }

    @Override
    public List<RoleDTO> findByUsersId(Long id) {
        return roleMapper.toDTO(roleRepository.findByUsersId(id));
    }
}
