package com.emond.mall.provider.system.dto;

import com.emond.mall.common.dto.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Set;

/**
 * @author: Chen Weiming
 */
@Data
@ApiModel("用户")
public class UserDTO extends BaseDTO {

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("状态")
    private Boolean enabled;

    @ApiModelProperty("密码")
    @JsonIgnore
    private String password;

    @ApiModelProperty("角色")
    private Set<RoleDTO> roles;
}
