package com.emond.mall.business.system.domain;

import com.emond.mall.common.annotation.ValidMobile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author: Chen Weiming
 */
@Data
@ApiModel("个人中心")
public class UserProfile {

    @NotNull
    private Long id;

    @ApiModelProperty("昵称")
    @NotBlank
    @Size(min = 2, max = 20, message = "{range}")
    private String nickName;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("电话")
    @NotBlank
    @ValidMobile
    private String phone;
}
