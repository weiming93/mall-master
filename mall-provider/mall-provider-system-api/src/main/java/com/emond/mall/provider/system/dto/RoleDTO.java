package com.emond.mall.provider.system.dto;

import com.emond.mall.common.dto.BaseDTO;
import lombok.Data;

import java.util.Set;

/**
 * @description:
 * @author: Chen Weiming
 */
@Data
public class RoleDTO extends BaseDTO {

    private String name;

    private String permission;

    private Integer level;

    private String remark;

    private Set<MenuDTO> menus;
}
