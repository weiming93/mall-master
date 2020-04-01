package com.emond.mall.auth.mapper;

import com.emond.mall.auth.domain.Menu;
import com.emond.mall.auth.domain.Role;
import com.emond.mall.auth.domain.User;
import com.emond.mall.common.domain.UserPrincipal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Chen Weiming
 */
public class UserPrincipalMapper {
    public static UserPrincipal create(User user) {
        final List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : user.getRoles()) {
            authorities.addAll(AuthorityUtils.commaSeparatedStringToAuthorityList(role.getPermission()));
            for (Menu menu : role.getMenus()) {
                authorities.addAll(AuthorityUtils.commaSeparatedStringToAuthorityList(menu.getPermission()));
            }
        }

        return UserPrincipal.builder()
                .id(user.getId())
                .username(user.getUsername())
                .enabled(user.getEnabled())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}
