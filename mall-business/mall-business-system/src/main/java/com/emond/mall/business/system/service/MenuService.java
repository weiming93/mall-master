package com.emond.mall.business.system.service;

import com.emond.mall.business.system.domain.Menu;
import com.emond.mall.business.system.domain.Role;
import com.emond.mall.common.domain.ElTree;
import com.emond.mall.common.service.BaseService;
import com.emond.mall.provider.system.dto.MenuDTO;
import com.emond.mall.provider.system.vo.Routes;

import java.util.List;

public interface MenuService extends BaseService<Menu> {

    /**
     * 查询角色拥有的菜单,按类型排序
     * @param roles
     * @return
     */
    List<Menu> findByRolesIdAndTypeInOrderBySortAsc(List<Role> roles);

    /**
     * 构建菜单树
     * @param menus
     * @return
     */
    List<MenuDTO> buildTree(List<Menu> menus);

    /**
     * 构建Vue-router路由
     * @param trees
     * @return
     */
    List<Routes> buildMenus(List<MenuDTO> trees);

    /**
     * 查找指定pid的菜单
     * @param pid
     * @return
     */
    List<Menu> findByPid(Long pid);

    /**
     * 菜单转为ElTree
     * @param resources
     * @return
     */
    List<ElTree> getMenuTree(List<Menu> resources);

    /**
     * 获取路由
     * @return
     */
    List<Routes> getRoutes();

}
