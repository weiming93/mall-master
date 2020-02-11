package com.emond.mall.auth.service.impl;

import com.emond.mall.auth.domain.UserPrincipal;
import com.emond.mall.provider.user.domain.User;
import com.emond.mall.provider.user.rpc.UserQueryRpc;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Emond Chan
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Reference
    private UserQueryRpc userQueryRpc;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        User user = userQueryRpc.loadUserByUsername(usernameOrEmail);
        return UserPrincipal.create(user);
    }
}
