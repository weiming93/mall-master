package com.emond.mall.provider.user.dto;

import lombok.Data;

/**
 * @description:
 * @author: Emond Chan
 */
@Data
public class RoleDTO {

    private Long id;

    private String name;

    private String permission;
}
