package com.emond.mall.provider.goods.dto;

import com.emond.mall.provider.goods.enums.Style;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Chen Weiming
 */
@Data
@ApiModel(value = "商品属性")
public class AttributeDTO extends AttributeParameterCommunityDTO{

    @ApiModelProperty("分类筛选样式")
    private Style style;

    @ApiModelProperty("是否支持手动新增.true:是,false:否")
    private Boolean added;
}
