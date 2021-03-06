package com.emond.mall.business.domain;

import com.emond.mall.common.converter.SetStringConverter;
import com.emond.mall.common.domain.IdentityModel;
import com.emond.mall.common.formatter.AmountUnitJsonFormat;
import com.emond.mall.common.formatter.WeightUnitJsonFormat;
import com.emond.mall.provider.setting.enums.CostCalculation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author: Chen Weiming
 */
@Setter
@Getter
@Table
@Entity
@ApiModel(value = "运费模板")
public class Freight extends IdentityModel {

    @NotBlank
    @Size(min = 2, max = 20, message = "{range}")
    @Column(unique = true)
    @ApiModelProperty("模板名称")
    private String name;

    @NotNull
    @ApiModelProperty("运费计算方式")
    @Enumerated(EnumType.STRING)
    private CostCalculation costCalculation;

    @WeightUnitJsonFormat
    @Column(name = "first_weight")
    @NotNull
    @ApiModelProperty("首重(g)")
    private Long firstWeight;

    @AmountUnitJsonFormat
    @Column(name = "first_cost")
    @NotNull
    @ApiModelProperty("首费(分)")
    private Long firstCost;

    @WeightUnitJsonFormat
    @Column(name = "increase_weight")
    @NotNull
    @ApiModelProperty("续重(g)")
    private Long increaseWeight;

    @AmountUnitJsonFormat
    @Column(name = "increase_cost")
    @NotNull
    @ApiModelProperty("续费(分)")

    private Long increaseCost;

    @NotNull
    @Convert(converter = SetStringConverter.class)
    @ApiModelProperty("目的地")
    private Set<String> destination;

    @NotNull
    @ApiModelProperty("是否启用;true:是,false:否")
    private Boolean enabled;

}
