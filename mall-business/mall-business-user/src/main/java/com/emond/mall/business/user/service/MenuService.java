package com.emond.mall.business.user.service;

import com.emond.mall.provider.user.domain.Menu;
import com.emond.mall.provider.user.dto.MenuDTO;
import com.emond.mall.provider.user.dto.RoleDTO;
import com.emond.mall.provider.user.vo.MenuVo;

import java.util.List;

public interface MenuService {
    Menu create(Menu menu);

    void delete(Long id);

    void update(Menu menu);

    Menu findById(Long id);

    List<MenuDTO> findByRolesIdAndTypeInOrderBySortAsc(List<RoleDTO> roles);

    List<MenuDTO> buildTree(List<MenuDTO> menuDTOList);

    List<MenuVo> buildMenus(List<MenuDTO> trees);
}
