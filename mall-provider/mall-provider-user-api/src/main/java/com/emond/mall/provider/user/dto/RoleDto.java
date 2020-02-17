package com.emond.mall.provider.user.dto;

import lombok.Data;

/**
 * @description:
 * @author: Emond Chan
 */
@Data
public class RoleDto {

    private Long id;

    private String name;

    private String permission;
}
