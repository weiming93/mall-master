package com.emond.mall.business.system.service;

import com.emond.mall.business.system.domain.Menu;
import com.emond.mall.business.system.domain.Role;
import com.emond.mall.business.system.domain.query.MenuQueryCriteria;
import com.emond.mall.common.domain.ElTree;
import com.emond.mall.provider.system.dto.MenuDTO;
import com.emond.mall.provider.system.vo.Routes;

import java.util.List;
import java.util.Set;

public interface MenuService {
    Menu create(Menu resources);

    void delete(Set<Long> ids);

    void update(Menu resources);

    Menu findById(Long id);

    List<Menu> findByRolesIdAndTypeInOrderBySortAsc(List<Role> roles);

    List<MenuDTO> buildTree(List<Menu> menus);

    List<Routes> buildMenus(List<MenuDTO> trees);

    List<Menu> queryAll(MenuQueryCriteria criteria);

    List<Menu> findByPid(Long pid);

    List<ElTree> getMenuTree(List<Menu> resources);

    List<Routes> getRoutes();

}
