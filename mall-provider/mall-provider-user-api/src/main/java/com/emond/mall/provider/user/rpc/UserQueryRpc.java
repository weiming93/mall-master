package com.emond.mall.provider.user.rpc;

import com.emond.mall.provider.user.dto.UserDTO;

public interface UserQueryRpc {

    UserDTO loadUserByUsername(String usernameOrEmail);
}
