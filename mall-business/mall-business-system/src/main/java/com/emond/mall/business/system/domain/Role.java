package com.emond.mall.business.system.domain;

import com.emond.mall.common.domain.IdentityModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Setter
@Getter
@Entity
@ApiModel("角色")
public class Role extends IdentityModel {

    @NotBlank
    @Column(unique = true)
    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("权限")
    private String permission;

    @ApiModelProperty("数值越小，级别越大")
    private Integer level = 3;

    @ApiModelProperty("用户")
    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @ApiModelProperty("菜单")
    @ManyToMany
    @JoinTable(name = "roles_menus",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id"))
    private Set<Menu> menus;

}
