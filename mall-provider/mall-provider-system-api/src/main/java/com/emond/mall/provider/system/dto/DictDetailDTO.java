package com.emond.mall.provider.system.dto;

import com.emond.mall.common.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Chen Weiming
 */
@Data
@ApiModel("字典详情")
public class DictDetailDTO extends BaseDTO {

    @ApiModelProperty("字典标签")
    private String label;

    @ApiModelProperty("字典值")
    private String value;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("字典")
    private DictDTO dict;

}
