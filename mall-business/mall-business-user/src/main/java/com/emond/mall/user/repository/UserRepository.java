package com.emond.mall.user.repository;

import com.emond.mall.provider.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import th.co.geniustree.springdata.jpa.repository.JpaSpecificationExecutorWithProjection;

public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutorWithProjection {


    User findByUsernameOrEmail(String username, String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
