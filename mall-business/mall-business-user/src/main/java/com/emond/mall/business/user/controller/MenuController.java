package com.emond.mall.business.user.controller;

import com.emond.mall.business.user.service.MenuService;
import com.emond.mall.business.user.service.RoleService;
import com.emond.mall.business.user.service.UserService;
import com.emond.mall.common.domain.Create;
import com.emond.mall.common.domain.Update;
import com.emond.mall.common.utils.OAuth2Utils;
import com.emond.mall.provider.user.domain.Menu;
import com.emond.mall.provider.user.dto.MenuDTO;
import com.emond.mall.provider.user.dto.UserDTO;
import com.emond.mall.provider.user.vo.MenuVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "菜单管理")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @ApiOperation("通过ID获取menu")
    @GetMapping("{id}")
    public Menu findById(@PathVariable Long id){
        return menuService.findById(id);
    }

    @ApiOperation("新增菜单")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Menu create(@Validated(Create.class) @RequestBody Menu menu){
        return menuService.create(menu);
    }

    @ApiOperation("删除菜单")
    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        menuService.delete(id);
    }

    @ApiOperation("修改菜单")
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Validated(Update.class) @RequestBody Menu menu){
        menuService.update(menu);
    }

    @ApiOperation("获取前端所需菜单数")
    @GetMapping(value = "/trees")
    public List<MenuVo> buildMenus(){
        UserDTO user = userService.findById(OAuth2Utils.getCurrentUserId());
        List<MenuDTO> menuDTOList = menuService.findByRolesIdAndTypeInOrderBySortAsc(roleService.findByUsersId(user.getId()));
        List<MenuDTO> trees = menuService.buildTree(menuDTOList);
        return menuService.buildMenus(trees);
    }

}
