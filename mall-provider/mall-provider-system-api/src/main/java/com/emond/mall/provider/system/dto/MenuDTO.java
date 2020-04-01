package com.emond.mall.provider.system.dto;

import com.emond.mall.common.dto.BaseDTO;
import com.emond.mall.provider.system.enums.MenuType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@Data
@ApiModel("菜单")
public class MenuDTO extends BaseDTO {

    @ApiModelProperty("菜单名称")
    private String name;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("对应路由path")
    private String path;

    @ApiModelProperty("对应路由组件component")
    private String component;

    @ApiModelProperty("菜单类型")
    private MenuType type;

    @ApiModelProperty("权限")
    private String permission;

    @ApiModelProperty("组件名称")
    private String componentName;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("上级菜单ID")
    private Long pid;

    @ApiModelProperty("外链菜单;是:true,否:false")
    private Boolean iFrame;

    @ApiModelProperty("菜单缓存;是:true,否:false")
    private Boolean cache;

    @ApiModelProperty("菜单可见;是:true,否:false")
    private Boolean hidden;

    private List<MenuDTO> children;

}
