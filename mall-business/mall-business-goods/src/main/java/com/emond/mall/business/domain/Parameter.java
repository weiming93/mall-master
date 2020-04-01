package com.emond.mall.business.domain;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author: Chen Weiming
 */
@Setter
@Getter
@Entity
@Table(name = "parameter")
@ApiModel(value = "商品参数")
public class Parameter extends AttributeParameterCommunity {
}
