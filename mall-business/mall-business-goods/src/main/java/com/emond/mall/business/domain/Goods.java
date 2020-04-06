package com.emond.mall.business.domain;

import com.emond.mall.common.domain.IdentityModel;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;

/**
 * @author: Chen Weiming
 */
@Setter
@Getter
@Table(name = "goods")
@ApiModel(value = "商品")
public class Goods extends IdentityModel {


}
