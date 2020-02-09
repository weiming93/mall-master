package com.emond.mall.auth.service.impl;

import com.emond.mall.auth.domain.UserPrincipal;
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

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        return new UserPrincipal(1l,"admin",
                usernameOrEmail,usernameOrEmail,passwordEncoder.encode("123456"),
                true, AuthorityUtils.commaSeparatedStringToAuthorityList("user:add"));
    }
}
