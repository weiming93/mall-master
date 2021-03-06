package com.emond.mall.auth.repository;

import com.emond.mall.auth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsernameOrEmailOrPhone(String username, String email, String phone);
}
