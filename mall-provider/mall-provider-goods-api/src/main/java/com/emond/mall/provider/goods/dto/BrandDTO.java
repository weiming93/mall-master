package com.emond.mall.provider.goods.dto;

import com.emond.mall.common.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:
 * @author: Chen Weiming
 */
@Data
@ApiModel("品牌数据传输对象")
public class BrandDTO extends BaseDTO {

    @ApiModelProperty("品牌名称")
    private String name;

    @ApiModelProperty("品牌LOGO")
    private String logo;

    @ApiModelProperty("品牌首字母")
    private String letter;

    @ApiModelProperty("品牌专区大图")
    private String bigPic;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("显示: true是,false否")
    private Boolean visibled;

    @ApiModelProperty("品牌制造商: true是,false否")
    private Boolean brandFactory;

    @ApiModelProperty(value = "品牌故事")
    private String brandStory;
}
