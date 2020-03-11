package com.emond.mall.business.user.service;

import com.emond.mall.business.user.domain.User;
import com.emond.mall.provider.user.dto.UserDTO;

public interface UserService {

    UserDTO findByUsernameOrEmail(String username, String email);

    User create(User user);

    void delete(Long id);

    UserDTO findById(Long currentUserId);
}
