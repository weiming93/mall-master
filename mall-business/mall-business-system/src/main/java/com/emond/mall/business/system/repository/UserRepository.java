package com.emond.mall.business.system.repository;

import com.emond.mall.business.system.domain.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.Optional;

public interface UserRepository extends JpaRepositoryImplementation<User,Long> {


    Optional<User> findByUsernameOrEmail(String username, String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    boolean existsByUsernameAndIdNot(String username, Long userId);

    boolean existsByEmailAndIdNot(String email, Long userId);

    boolean existsByPhone(String email);

    boolean existsByPhoneAndIdNot(String phone, Long userId);

    Optional<User> findByUsernameOrEmailOrPhone(String username, String email, String phone);
}
