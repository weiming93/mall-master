package com.emond.mall.provider.setting.dto;

import com.emond.mall.common.dto.BaseDTO;
import com.emond.mall.common.formatter.AmountUnitJsonFormat;
import com.emond.mall.common.formatter.WeightUnitJsonFormat;
import com.emond.mall.provider.setting.enums.CostCalculation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Set;

/**
 * @author: Chen Weiming
 */
@Data
@ApiModel("运费模板DTO")
public class FreightDTO extends BaseDTO {

    @ApiModelProperty("模板名称")
    private String name;

    @ApiModelProperty("运费计算方式")
    private CostCalculation costCalculation;

    @WeightUnitJsonFormat
    @ApiModelProperty("首重(g)")
    private Long firstWeight;

    @AmountUnitJsonFormat
    @ApiModelProperty("首费(分)")
    private Long firstCost;

    @WeightUnitJsonFormat
    @ApiModelProperty("续重(g)")
    private Long increaseWeight;

    @AmountUnitJsonFormat
    @ApiModelProperty("续费(分)")
    private Long increaseCost;

    @ApiModelProperty("目的地")
    private Set<String> destination;

    private Boolean enabled;
}
