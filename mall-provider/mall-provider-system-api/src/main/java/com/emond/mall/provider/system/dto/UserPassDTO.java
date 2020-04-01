package com.emond.mall.provider.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 修改密码的 DTO 类
 * @author: Chen Weiming
 */
@Data
@ApiModel("密码修改")
public class UserPassDTO {
    @ApiModelProperty("旧密码")
    private String oldPass;
    @ApiModelProperty("新密码")
    private String newPass;
}
