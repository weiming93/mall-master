package com.blueocean.mall.provider.model;

import com.blueocean.mall.common.auditing.UserDateAudit;
import com.blueocean.mall.common.model.IdentityModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@EqualsAndHashCode(of = "id")
@Entity
public class Role extends IdentityModel {

    @Embedded
    private UserDateAudit userDateAudit;

    @NaturalId
    private String name;

    @Column
    private String remark;

    @Column
    private String permission;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @ManyToMany
    @JoinTable(name = "roles_menus",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id"))
    private Set<Menu> menus;

    @ManyToMany
    @JoinTable(name = "roles_menus",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "dept_id"))
    private Set<Dept> depts;
}
