package com.emond.mall.business.system.domain;

import com.emond.mall.common.domain.IdentityModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author: Chen Weiming
 */
@Entity
@Getter
@Setter
@Table(name="dict_detail")
@ApiModel("字典详情")
public class DictDetail  extends IdentityModel {
    @ApiModelProperty("字典标签")
    @NotBlank
    private String label;

    @ApiModelProperty("字典值")
    @NotBlank
    private String value;

    @NotNull
    @ApiModelProperty("排序")
    private Integer sort;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "dict_id")
    @ApiModelProperty("字典")
    private Dict dict;


}
