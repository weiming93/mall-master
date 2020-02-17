package com.emond.mall.business.user.controller;

import com.emond.mall.common.domain.Create;
import com.emond.mall.provider.user.domain.Role;

import com.emond.mall.business.user.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('role:create')")
    public Role create(@Validated(Create.class) @RequestBody Role role){
        return roleService.create(role);
    }
}
