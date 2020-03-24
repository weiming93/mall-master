package com.emond.mall.provider.system.dto;

import com.emond.mall.common.dto.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: Emond Chan
 */
@Data
public class UserDTO extends BaseDTO {

    private String username;

    private String email;

    private String phone;

    private Boolean enabled;
    @JsonIgnore
    private String password;

    private Set<RoleDTO> roles = new HashSet<>();
}
