package com.emond.mall.auth.repository;

import com.emond.mall.provider.user.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
