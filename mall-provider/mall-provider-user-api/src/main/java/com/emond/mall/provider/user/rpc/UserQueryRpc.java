package com.emond.mall.provider.user.rpc;

import com.emond.mall.provider.user.dto.UserDto;

public interface UserQueryRpc {

    UserDto loadUserByUsername(String usernameOrEmail);
}
