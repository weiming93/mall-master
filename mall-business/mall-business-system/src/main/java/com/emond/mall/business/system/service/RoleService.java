package com.emond.mall.business.system.service;


import com.emond.mall.business.system.domain.Role;
import com.emond.mall.business.system.domain.query.RoleQueryCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface RoleService {
    Role create(Role resources);

    void delete(Set<Long> ids);

    void update(Role resources);

    Role findById(Long id);

    List<Role> findByUsersId(Long id);

    Page<Role> getRolePage(RoleQueryCriteria criteria, Pageable pageable);

    Integer getLevels(Integer level);

    void updateMenu(Role resources);

    void untiedMenu(Long id);

    List<Role> findAll(Pageable pageable);
}
