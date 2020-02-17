package com.emond.mall.business.user.repository;

import com.emond.mall.provider.user.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Boolean existsByName(String roleName);
}
