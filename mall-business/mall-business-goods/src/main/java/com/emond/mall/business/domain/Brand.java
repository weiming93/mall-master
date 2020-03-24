package com.emond.mall.business.domain;

import com.emond.mall.common.domain.IdentityModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@ApiModel("品牌")
public class Brand extends IdentityModel {

    @NotBlank
    @ApiModelProperty("品牌名称")
    private String name;

    @ApiModelProperty("品牌LOGO")
    @NotBlank
    private String logo;

    @NotBlank
    @ApiModelProperty("品牌首字母")
    private String letter;

    @ApiModelProperty("品牌专区大图")
    private String bigPic;

    @NotNull
    @ApiModelProperty("排序")
    private Integer sort;

    @NotNull
    @ApiModelProperty("显示: true是,false否")
    private Boolean visibled;

    @NotNull
    @ApiModelProperty("品牌制造商: true是,false否")
    private Boolean brandFactory;

    @ApiModelProperty(value = "品牌故事")
    private String brandStory;


}
