package com.blueocean.mall.provider.controller;

import com.blueocean.mall.common.domain.Create;
import com.blueocean.mall.provider.domain.Role;
import com.blueocean.mall.provider.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
@Tag(name = "系统：用户管理")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Operation(summary = "新增角色")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('role:create')")
    public Role create(@Validated(Create.class) @RequestBody Role role){
        return roleService.create(role);
    }
}
