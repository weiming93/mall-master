package com.emond.mall.provider.controller;

import com.emond.mall.common.exception.BadRequestException;
import com.emond.mall.provider.domain.Dept;
import com.emond.mall.provider.service.DeptService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "系统：部门管理")
@RestController
@RequestMapping("/api/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Operation(summary = "新增部门")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dept create(@Valid @RequestBody Dept dept){
        if (dept.getId() != null) {
            throw new BadRequestException("dept存在ID值");
        }
        return deptService.create(dept);
    }
}
