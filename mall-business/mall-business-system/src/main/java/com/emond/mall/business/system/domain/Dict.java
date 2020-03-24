package com.emond.mall.business.system.domain;

import com.emond.mall.common.domain.IdentityModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

/**
 * @description:
 * @author: Chen Weiming
 */
@Entity
@Getter
@Setter
public class Dict extends IdentityModel {
    @Column(name = "name",nullable = false,unique = true)
    @NotBlank
    private String name;

    @Column(name = "remark")
    private String remark;
}
