package com.blueocean.mall.common.repository;

import com.blueocean.mall.common.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
