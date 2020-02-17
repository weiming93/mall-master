package com.emond.mall.business.user.service;

import com.emond.mall.provider.user.domain.User;
import com.emond.mall.provider.user.dto.UserDto;

public interface UserService {

    UserDto findByUsernameOrEmail(String username, String email);

    User create(User user);
}
