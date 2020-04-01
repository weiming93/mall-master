package com.emond.mall.business.domain;

import com.emond.mall.common.domain.IdentityModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @author: Chen Weiming
 */
@Setter
@Getter
@Entity
@ApiModel("商品分类")
public class Category extends IdentityModel {
    @NotBlank
    @ApiModelProperty("分类名称")
    private String name;

    @ApiModelProperty("上级分类ID")
    private Long pid = 0L;

    @ApiModelProperty("数量单位")
    private String unit;

    @ApiModelProperty("排序")
    private Integer sort = 999;

    @NotNull
    @ApiModelProperty("是否显示;true:是,false:否")
    private Boolean visibled;

    @NotNull
    @ApiModelProperty("是否显示在导航栏;true:是,false:否")
    private Boolean navigation;

    @NotBlank
    @ApiModelProperty("分类图标")
    private String icon;

    @ApiModelProperty("分类属性")
    @ManyToMany
    @JoinTable(name = "categories_attributes",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_id"))
    private Set<Attribute> attributes;

    @ApiModelProperty("关键词")
    private String keyword;

    @ApiModelProperty("描述")
    private String description;
}
