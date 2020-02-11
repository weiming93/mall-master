package com.emond.mall.business.user.rpc;

import com.emond.mall.business.user.service.UserService;
import com.emond.mall.provider.user.domain.User;
import com.emond.mall.provider.user.rpc.UserQueryRpc;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: Emond Chan
 */
@Service
public class UserQueryRpcImpl implements UserQueryRpc {

    @Autowired
    private UserService userService;
    @Override
    public User loadUserByUsername(String usernameOrEmail) {
        return userService.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail);
    }
}
