package com.emond.mall.business.system.domain;

import com.emond.mall.common.domain.IdentityModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
public class Role extends IdentityModel {

    @NaturalId
    private String name;

    @Column
    private String remark;

    @Column
    private String permission;

    /** 数值越小，级别越大 */
    private Integer level = 3;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @ManyToMany
    @JoinTable(name = "roles_menus",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id"))
    private Set<Menu> menus;

}