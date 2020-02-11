package com.emond.mall.provider.user.rpc;

import com.emond.mall.provider.user.domain.User;

public interface UserQueryRpc {

    User loadUserByUsername(String usernameOrEmail);
}
