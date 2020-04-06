package com.emond.mall.business.system.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author: Chen Weiming
 */
@Data
@ApiModel("用户头像")
public class UserAvatar {

    @NotNull
    private Long id;

    @ApiModelProperty("头像")
    @NotBlank
    private String avatar;

}
