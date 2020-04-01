package com.emond.mall.provider.goods.dto;

import com.emond.mall.common.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Chen Weiming
 */
@Data
@ApiModel("商品类型")
public class TypeSmallDTO extends BaseDTO {
    @ApiModelProperty("类型名称")
    private String name;
}
