package com.blueocean.mall.provider.model;

import com.blueocean.mall.common.model.IdentityModel;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
public class Role extends IdentityModel {

    @NaturalId
    @Size(max = 40)
    private String name;

    private String remark;

    private String permission;
}
