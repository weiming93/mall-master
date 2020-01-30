package com.emond.mall.common.repository;

import com.emond.mall.common.domain.User;
import com.emond.mall.common.projection.UserProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    @Query(value = "select id from user where id = ?1",nativeQuery = true)
    UserProjection findProjectionById(Long id);
}
