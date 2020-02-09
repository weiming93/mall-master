package com.emond.mall.user.service;

import com.emond.mall.provider.domain.User;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<User> findByUsernameOrEmail(String username, String email);

    Mono<User> create(User user);
}
