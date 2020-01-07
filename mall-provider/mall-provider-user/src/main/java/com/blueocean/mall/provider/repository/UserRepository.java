package com.blueocean.mall.provider.repository;

import com.blueocean.mall.provider.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import th.co.geniustree.springdata.jpa.repository.JpaSpecificationExecutorWithProjection;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutorWithProjection {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    List<User> findByIdIn(List<Long> userIds);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
