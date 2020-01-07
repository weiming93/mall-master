package com.blueocean.mall.provider.utils;

import com.blueocean.mall.common.core.UserPrincipal;
import com.blueocean.mall.provider.domain.User;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class ModelMapper {

    public UserPrincipal mapUserToUserPrincipal(User user){
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getPermission())
        ).collect(Collectors.toList());

        return new UserPrincipal(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getEnabled(),
                authorities
        );
    }
}
