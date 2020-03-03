package com.emond.mall.provider.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: Emond Chan
 */
@Data
public class UserDTO implements Serializable {
    private Long id;

    private String name;

    private String username;

    private String email;

    private String phone;

    private Boolean enabled;
    @JsonIgnore
    private String password;

    private Set<RoleDTO> roles = new HashSet<>();
}
