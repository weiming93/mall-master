package com.emond.mall.business.domain;

import com.emond.mall.common.converter.SetStringConverter;
import com.emond.mall.common.domain.IdentityModel;
import com.emond.mall.provider.goods.enums.Searching;
import com.emond.mall.provider.goods.enums.Selected;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * 属性和参数的公共类
 *
 * @author: Chen Weiming
 */
@Setter
@Getter
@MappedSuperclass
public abstract class AttributeParameterCommunity extends IdentityModel {
    @NotBlank
    @ApiModelProperty("名称")
    private String name;

    @NotNull
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "type_id")
    @ApiModelProperty("商品类型")
    private Type type;

    @Enumerated(EnumType.STRING)
    @NotNull
    @ApiModelProperty("能否进行检索")
    private Searching searching;

    @NotNull
    @ApiModelProperty("相同属性值的商品是否关联.true:是,false:否")
    private Boolean related;

    @Enumerated(EnumType.STRING)
    @NotNull
    @ApiModelProperty("属性是否可选")
    private Selected selected;

    @NotNull
    @Convert(converter = SetStringConverter.class)
    @ApiModelProperty("可选值列表")
    private Set<String> optionals;

    @NotNull
    @ApiModelProperty("排序")
    private Integer sort;
}
