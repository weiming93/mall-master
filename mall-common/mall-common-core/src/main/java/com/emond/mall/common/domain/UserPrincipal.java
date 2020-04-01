package com.emond.mall.common.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author Chen Weiming
 */
@EqualsAndHashCode(of = "id")
@Value
@Builder
public class UserPrincipal implements UserDetails {

    private static final long serialVersionUID = -7551136369736864900L;
    private Long id;

    private String username;

    @JsonIgnore
    private String password;

    private Boolean enabled;

    private Collection<? extends GrantedAuthority> authorities;


    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }



}
