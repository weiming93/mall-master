package com.blueocean.mall.provider.service;

import com.blueocean.mall.provider.domain.User;

public interface UserService {

    User findByUsernameOrEmail(String username, String email);

    User create(User user);
}
