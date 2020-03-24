package com.emond.mall.business.system.domain;

import com.emond.mall.common.domain.IdentityModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * @description:
 * @author: Chen Weiming
 */
@Entity
@Getter
@Setter
@Table(name="dict_detail")
public class DictDetail  extends IdentityModel {
    @ApiModelProperty("字典标签")
    @Column(nullable = false)
    @NotBlank
    private String label;

    @ApiModelProperty("字典值")
    @Column(nullable = false)
    @NotBlank
    private String value;

    /** 排序 */
    @Column(nullable = false)
    private String sort = "999";




}
