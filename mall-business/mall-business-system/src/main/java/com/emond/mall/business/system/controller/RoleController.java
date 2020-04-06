package com.emond.mall.business.system.controller;

import com.emond.mall.business.system.domain.Role;
import com.emond.mall.business.system.query.RoleQueryCriteria;
import com.emond.mall.business.system.mapper.RoleMapper;
import com.emond.mall.business.system.service.RoleService;
import com.emond.mall.common.domain.Create;
import com.emond.mall.common.domain.Update;
import com.emond.mall.provider.system.dto.RoleDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Api(tags = "角色管理")
@RestController
@RequestMapping("/role")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleController {

    private final RoleService roleService;

    private final RoleMapper roleMapper;

    @ApiOperation("通过ID获取角色 ")
    @GetMapping("{id}")
    public RoleDTO findById(@PathVariable Long id){
        return roleMapper.toDTO(roleService.findById(id));
    }

    @ApiOperation("分页查询角色")
    @GetMapping
    public Page<RoleDTO> getRolePage(RoleQueryCriteria criteria, Pageable pageable){
        return roleMapper.toPage(roleService.findPage(criteria,pageable));
    }
    @ApiOperation("获取用户级别")
    @GetMapping(value = "/level")
    public Integer getLevel(){
        return roleService.getLevels(Integer.MAX_VALUE);
    }

    @ApiOperation("新增角色")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoleDTO create(@Validated @RequestBody Role resources){
        return roleMapper.toDTO(roleService.create(resources));
    }

    @ApiOperation("删除角色")
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody Set<Long> ids){
        roleService.delete(ids);
    }

    @ApiOperation("修改角色")
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Validated @RequestBody Role resources){
        roleService.update(resources);
    }


    @ApiOperation("修改角色菜单")
    @PutMapping(value = "/menu")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMenu(@RequestBody Role resources){
        roleService.updateMenu(resources);
    }

    @ApiOperation("返回全部的角色")
    @GetMapping(value = "/all")
    public List<RoleDTO> findAll(@PageableDefault(value = 2000, sort = {"level"}, direction = Sort.Direction.ASC) Pageable pageable){
        return roleMapper.toDTO(roleService.findAll(pageable));
    }
}
