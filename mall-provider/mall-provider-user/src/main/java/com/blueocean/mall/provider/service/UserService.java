package com.blueocean.mall.provider.service;

import com.blueocean.mall.provider.domain.User;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<User> findByUsernameOrEmail(String username, String email);

    Mono<User> create(User user);
}
