package com.emond.mall.business.user.repository;

import com.emond.mall.provider.user.domain.Role;
import com.emond.mall.provider.user.dto.RoleDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Boolean existsByName(String roleName);

    List<Role> findByUsersId(Long id);
}
