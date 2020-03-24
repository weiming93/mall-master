//package com.emond.mall.business.system.domain;
//
//import com.emond.mall.common.domain.IdentityModel;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.Entity;
//import javax.persistence.ManyToMany;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import java.util.Set;
//
//@Setter
//@Getter
//@Entity
//public class Dept extends IdentityModel {
//    @NotBlank
//    private String name;
//
//    @NotNull
//    private Boolean enabled;
//
//    @NotNull
//    private Long pid;
//
//    @JsonIgnore
//    @ManyToMany(mappedBy = "depts")
//    private Set<Role> roles;
//
//
//}