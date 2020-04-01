package com.emond.mall.business.domain;

import com.emond.mall.provider.goods.enums.Style;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author: Chen Weiming
 */
@Setter
@Getter
@Entity
@Table(name = "attribute")
@ApiModel(value = "商品属性")
public class Attribute extends AttributeParameterCommunity {


    @Enumerated(EnumType.STRING)
    @NotNull
    @ApiModelProperty("分类筛选样式")
    private Style style;

    @NotNull
    @ApiModelProperty("是否支持手动新增.true:是,false:否")
    private Boolean added;


}
