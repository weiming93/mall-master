package com.emond.mall.business.domain;

import com.emond.mall.common.domain.IdentityModel;
import com.emond.mall.provider.setting.enums.CostCalculation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @author: Chen Weiming
 */
@Setter
@Getter
@Table
@ApiModel(value = "运费模板")
public class Freight extends IdentityModel {

    @NotBlank
    @Size(min = 2, max = 20, message = "{range}")
    @Column(unique = true)
    @ApiModelProperty("模板名称")
    private String name;

    @NotNull
    @ApiModelProperty("运费计算方式")
    private CostCalculation costCalculation;

    @Column(name = "first_weight")
    @NotNull
    @ApiModelProperty("首重(g)")
    private BigDecimal firstWeight;

    @Column(name = "first_cost")
    @NotNull
    @ApiModelProperty("首费(分)")
    private BigDecimal firstCost;

    @Column(name = "re_weight")
    @NotNull
    @ApiModelProperty("续重(g)")
    private BigDecimal reWeight;

    @Column(name = "re_cost")
    @NotNull
    @ApiModelProperty("续费(分)")
    private BigDecimal reCost;



}
