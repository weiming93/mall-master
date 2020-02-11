package com.emond.mall.business.user.service;

import com.emond.mall.provider.user.domain.User;

public interface UserService {

    User findByUsernameOrEmail(String username, String email);

    User create(User user);
}
