package com.emond.mall.provider.goods.dto;

import com.emond.mall.common.dto.BaseDTO;
import com.emond.mall.provider.goods.enums.Searching;
import com.emond.mall.provider.goods.enums.Selected;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Set;

/**
 * @author: Chen Weiming
 */
@Data
public class AttributeParameterCommunityDTO extends BaseDTO {
    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("商品类型")
    private TypeSmallDTO type;


    @ApiModelProperty("能否进行检索")
    private Searching searching;

    @ApiModelProperty("相同属性值的商品是否关联.true:是,false:否")
    private Boolean related;

    @ApiModelProperty("属性是否可选")
    private Selected selected;

    @ApiModelProperty("可选值列表")
    private Set<String> optionals;

    @ApiModelProperty("排序")
    private Integer sort;

}
