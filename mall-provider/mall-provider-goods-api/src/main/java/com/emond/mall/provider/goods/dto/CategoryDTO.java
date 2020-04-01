package com.emond.mall.provider.goods.dto;

import com.emond.mall.common.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Set;

/**
 * @author: Chen Weiming
 */
@Data
public class CategoryDTO extends BaseDTO {

    @ApiModelProperty("分类名称")
    private String name;

    @ApiModelProperty("上级分类ID,一级分类默认为0")
    private Long pid;

    @ApiModelProperty("数量单位")
    private String unit;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("是否显示;true:是,false:否")
    private Boolean visibled;

    @ApiModelProperty("是否显示在导航栏;true:是,false:否")
    private Boolean navigation;

    @ApiModelProperty("分类图标")
    private String icon;

    @ApiModelProperty("分类属性")
    private Set<AttributeDTO> attributes;

    @ApiModelProperty("关键词")
    private String keyword;

    @ApiModelProperty("描述")
    private String description;
}
