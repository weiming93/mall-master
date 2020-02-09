package com.emond.mall.user.repository;

import com.emond.mall.provider.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import th.co.geniustree.springdata.jpa.repository.JpaSpecificationExecutorWithProjection;

public interface RoleRepository extends JpaRepository<Role,Long>, JpaSpecificationExecutorWithProjection {

    Boolean existsByName(String roleName);
}
