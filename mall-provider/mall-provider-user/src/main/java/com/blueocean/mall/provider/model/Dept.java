package com.blueocean.mall.provider.model;

import com.blueocean.mall.common.auditing.UserDateAudit;
import com.blueocean.mall.common.model.IdentityModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Setter
@Getter
@EqualsAndHashCode(of = "id")
@Entity
public class Dept extends IdentityModel {
    @Embedded
    private UserDateAudit userDateAudit;

    @NotBlank
    private String name;

    @NotNull
    private Boolean enabled;

    @NotNull
    private Long pid;

    @JsonIgnore
    @ManyToMany(mappedBy = "depts")
    private Set<Role> roles;


}
