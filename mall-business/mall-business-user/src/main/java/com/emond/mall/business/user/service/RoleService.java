package com.emond.mall.business.user.service;

import com.emond.mall.provider.user.domain.Role;
import com.emond.mall.provider.user.dto.RoleDTO;

import java.util.List;
import java.util.Set;

public interface RoleService {
    Role create(Role role);

    void delete(Long id);

    void update(Role role);

    Role findById(Long id);

    List<RoleDTO> findByUsersId(Long id);
}
