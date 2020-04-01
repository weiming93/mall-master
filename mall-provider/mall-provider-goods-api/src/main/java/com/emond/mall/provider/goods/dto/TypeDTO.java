package com.emond.mall.provider.goods.dto;

import com.emond.mall.common.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author: Chen Weiming
 */
@Data
@ApiModel("商品类型")
public class TypeDTO extends BaseDTO {
    @ApiModelProperty("类型名称")
    private String name;

    @ApiModelProperty("属性")
    private List<AttributeDTO> attributes;

    @ApiModelProperty("参数")
    private List<ParameterDTO> parameters;
}
