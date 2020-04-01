package com.emond.mall.provider.system.dto;

import com.emond.mall.common.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Set;

/**
 * @author: Chen Weiming
 */
@Data
@ApiModel("用户")
public class RoleDTO extends BaseDTO {

    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("权限")
    private String permission;

    @ApiModelProperty("数值越小，级别越大")
    private Integer level = 3;

    @ApiModelProperty("菜单")
    private Set<MenuDTO> menus;
}
