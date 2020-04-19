package com.emond.mall.business.system.domain;

import com.emond.mall.common.annotation.ValidEmail;
import com.emond.mall.common.annotation.ValidMobile;
import com.emond.mall.common.domain.IdentityModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Chen Weiming
 */

@Entity
@Setter
@Getter
@Table( uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        }),
        @UniqueConstraint(columnNames = {
                "phone"
        })
})
@ApiModel("用户")
public class User extends IdentityModel {
    @ApiModelProperty("昵称")
    @NotBlank
    @Size(min = 2, max = 20, message = "{range}")
    private String nickName;

    @ApiModelProperty("用户名")
    @NotBlank
    @Size(min = 2, max = 20, message = "{range}")
    private String username;

    @ApiModelProperty("邮箱")
    @NotBlank
    @ValidEmail
    private String email;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("电话")
    @NotBlank
    @ValidMobile
    private String phone;

    @ApiModelProperty("状态")
    @NotNull
    private Boolean enabled;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("头像")
    private String avatar;

    @NotNull
    @ApiModelProperty("角色")
    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

}
