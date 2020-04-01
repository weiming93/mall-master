package com.emond.mall.business.domain;

import com.emond.mall.common.domain.IdentityModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * @author: Chen Weiming
 */
@Setter
@Getter
@Entity
@Table(name = "type")
@ApiModel("商品类型")
public class Type extends IdentityModel {
    @NotBlank
    @ApiModelProperty("类型名称")
    private String name;

    @ApiModelProperty("属性")
    @OneToMany(mappedBy = "type")
    private Set<Attribute> attributes;

    @ApiModelProperty("参数")
    @OneToMany(mappedBy = "type")
    private Set<Parameter> parameters;

}
