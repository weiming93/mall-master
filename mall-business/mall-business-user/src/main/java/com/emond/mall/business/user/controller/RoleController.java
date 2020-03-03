package com.emond.mall.business.user.controller;

import com.emond.mall.common.domain.Create;
import com.emond.mall.common.domain.Update;
import com.emond.mall.provider.user.domain.Role;

import com.emond.mall.business.user.service.RoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Api(tags = "角色管理")
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation("通过ID获取角色 ")
    @GetMapping("{id}")
    public Role findById(@PathVariable Long id){
        return roleService.findById(id);
    }

    @ApiOperation("新增角色")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('role:create')")
    public Role create(@Validated(Create.class) @RequestBody Role role){
        return roleService.create(role);
    }

    @ApiOperation("删除角色")
    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        roleService.delete(id);
    }

    @ApiOperation("修改角色")
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Validated(Update.class) @RequestBody Role role){
        roleService.update(role);
    }
}
