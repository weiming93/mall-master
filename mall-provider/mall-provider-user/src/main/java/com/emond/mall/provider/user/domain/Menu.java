package com.emond.mall.provider.user.domain;

import com.emond.mall.common.jpa.domain.IdentityModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
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

    @Column(name = "path")
    private String path;

    private String component;

    // 类型
    @Column(name = "type")
    private Integer type;

    // 权限
    @Column(name = "permission")
    private String permission;

    @Column(unique = true,name = "component_name")
    private String componentName;

    private String icon;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean cache;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean hidden;

    // 上级菜单ID
    @Column(name = "pid",nullable = false)
    private Long pid;

    // 是否为外链 true/false
    @Column(name = "i_frame")
    private Boolean iFrame;

    @ManyToMany(mappedBy = "menus")
    @JsonIgnore
    private Set<Role> roles;
}
