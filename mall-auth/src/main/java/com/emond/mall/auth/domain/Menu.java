package com.emond.mall.auth.domain;

import com.emond.mall.common.domain.IdentityModel;
import com.emond.mall.provider.user.enums.MenuType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Setter
@Getter
@EqualsAndHashCode(of = "id")
@Entity
public class Menu extends IdentityModel {
    @NotBlank
    private String name;

    @Column(unique = true)
    private Long sort = 999L;
    //对应路由path
    @Column(name = "path")
    private String path;
    //对应路由组件component
    private String component;

    // 类型
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private MenuType type;

    // 权限
    @Column(name = "permission")
    private String permission;

    @Column(unique = true,name = "component_name")
    private String componentName;
    //图标
    private String icon;

    // 上级菜单ID
    @Column(name = "pid",nullable = false)
    private Long pid;

    // 是否为外链 true/false
    @Column(name = "i_frame")
    private Boolean iFrame;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean cache;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean hidden;

    @ManyToMany(mappedBy = "menus")
    @JsonIgnore
    private Set<Role> roles;
}
