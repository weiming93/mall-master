package com.emond.mall.business.system.domain;

import com.emond.mall.common.domain.IdentityModel;
import com.emond.mall.provider.system.enums.MenuType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;
@Entity
@Setter
@Getter
@Table
@ApiModel("菜单")
public class Menu extends IdentityModel {
    @NotBlank
    @Column(unique = true)
    @ApiModelProperty("菜单名称")
    private String name;

    @NotNull
    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("对应路由path")
    private String path;

    @ApiModelProperty("对应路由组件component")
    private String component;

    @ApiModelProperty("菜单类型")
    @NotNull
    @Enumerated(EnumType.STRING)
    private MenuType type;

    @ApiModelProperty("权限")
    private String permission;

    @ApiModelProperty("组件名称")
    @Column(unique = true,name = "component_name")
    private String componentName;

    @ApiModelProperty("图标")
    private String icon;

    @NotNull
    @ApiModelProperty("上级菜单ID")
    private Long pid;

    @Column(name = "i_frame")
    @ApiModelProperty("外链菜单;是:true,否:false")
    private Boolean iFrame;

    @ApiModelProperty("菜单缓存;是:true,否:false")
    @NotNull
    private Boolean cache;

    @ApiModelProperty("菜单可见;是:true,否:false")
    @NotNull
    private Boolean hidden;

    @ApiModelProperty("角色")
    @ManyToMany(mappedBy = "menus")
    @JsonIgnore
    private Set<Role> roles;
}
