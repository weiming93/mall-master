package com.emond.mall.provider.system.dto;

import com.emond.mall.common.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Chen Weiming
 */
@Data
@ApiModel("字典")
public class DictDTO extends BaseDTO {

    @ApiModelProperty("字典名称")
    private String name;

    @ApiModelProperty("备注")
    private String remark;

}
