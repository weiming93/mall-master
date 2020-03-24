package com.emond.mall.auth.domain;

import com.emond.mall.common.annotation.ValidEmail;
import com.emond.mall.common.annotation.ValidMobile;
import com.emond.mall.common.domain.IdentityModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table( uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class User extends IdentityModel {

    @NotBlank
    @Size(min = 4, max = 20, message = "{range}")
    private String username;

    @NaturalId
    @NotBlank
    @ValidEmail
    private String email;

    @NotBlank
    @ValidMobile
    private String phone;

    @NotNull
    private Boolean enabled;
    @NotBlank
    private String password;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

}
