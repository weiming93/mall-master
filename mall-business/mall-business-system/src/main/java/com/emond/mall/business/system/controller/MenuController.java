package com.emond.mall.business.system.controller;


import com.emond.mall.business.system.domain.Menu;
import com.emond.mall.business.system.query.MenuQueryCriteria;
import com.emond.mall.business.system.mapper.MenuMapper;
import com.emond.mall.business.system.service.MenuService;
import com.emond.mall.common.domain.Create;
import com.emond.mall.common.domain.ElTree;
import com.emond.mall.common.domain.Update;
import com.emond.mall.provider.system.dto.MenuDTO;
import com.emond.mall.provider.system.vo.Routes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Api(tags = "菜单管理")
@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MenuController {


    private final MenuService menuService;

    private final MenuMapper menuMapper;


    @ApiOperation("查询菜单")
    @GetMapping
    public List<MenuDTO> getMenus(MenuQueryCriteria criteria){
        List<Menu> menus = menuService.findAll(criteria);
        return menuService.buildTree(menus);
    }

    @ApiOperation("返回菜单树")
    @GetMapping(value = "tree")
    public List<ElTree> getMenuTree(){
        return menuService.getMenuTree(menuService.findByPid(0L));
    }

    @ApiOperation("通过ID获取menu")
    @GetMapping("{id}")
    public MenuDTO findById(@PathVariable Long id){
        return menuMapper.toDTO(menuService.findById(id));
    }

    @ApiOperation("新增菜单")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MenuDTO create(@Validated @RequestBody Menu resources){
        return menuMapper.toDTO(menuService.create(resources));
    }

    @ApiOperation("删除菜单")
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody Set<Long> ids){
        menuService.delete(ids);
    }

    @ApiOperation("修改菜单")
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Validated @RequestBody Menu resources){
        menuService.update(resources);
    }

    @ApiOperation("获取路由")
    @GetMapping(value = "/routes")
    public List<Routes> getRoutes(){
        return menuService.getRoutes();
    }

}
