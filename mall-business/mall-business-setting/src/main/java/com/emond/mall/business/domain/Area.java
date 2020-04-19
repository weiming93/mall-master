package com.emond.mall.business.domain;

import com.emond.mall.common.domain.IdentityModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @author: Chen Weiming
 */
@ApiModel("地区")
@Entity
@Setter
@Getter
public class Area extends IdentityModel {

    @ApiModelProperty("父级ID")
    private Long pid;
    @ApiModelProperty("地区名")
    private String name;
    @ApiModelProperty("级别;1:省,2:市,3:区,4:乡、镇、街道")
    private Integer level;
    @ApiModelProperty("纬度")
    private Double lat;
    @ApiModelProperty("经度")
    private Double lng;
}
