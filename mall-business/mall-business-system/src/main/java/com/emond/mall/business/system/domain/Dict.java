package com.emond.mall.business.system.domain;

import com.emond.mall.common.domain.IdentityModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author: Chen Weiming
 */
@Entity
@Table
@Getter
@Setter
@ApiModel("字典")
public class Dict extends IdentityModel {
    @Column(unique = true)
    @NotBlank
    @ApiModelProperty("字典名称")
    private String name;

    @Column(name = "remark")
    @ApiModelProperty("备注")
    private String remark;

    @OneToMany(mappedBy = "dict",cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    @ApiModelProperty("字典详情")
    private List<DictDetail> dictDetails;
}
