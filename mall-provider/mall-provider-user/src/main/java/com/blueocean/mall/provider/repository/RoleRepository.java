package com.blueocean.mall.provider.repository;

import com.blueocean.mall.provider.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import th.co.geniustree.springdata.jpa.repository.JpaSpecificationExecutorWithProjection;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long>, JpaSpecificationExecutorWithProjection {

    Boolean existsByName(String roleName);
}
