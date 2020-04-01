package com.emond.mall.business.system.service.impl;

import com.emond.mall.business.system.domain.Menu;
import com.emond.mall.business.system.domain.Role;
import com.emond.mall.business.system.domain.User;
import com.emond.mall.business.system.mapper.MenuMapper;
import com.emond.mall.business.system.repository.MenuRepository;
import com.emond.mall.business.system.service.MenuService;
import com.emond.mall.business.system.service.RoleService;
import com.emond.mall.business.system.service.UserService;
import com.emond.mall.common.domain.ElTree;
import com.emond.mall.common.exception.BadRequestException;
import com.emond.mall.common.exception.EntityExistException;
import com.emond.mall.common.service.impl.BaseServiceImpl;
import com.emond.mall.common.utils.OAuth2Utils;
import com.emond.mall.provider.system.dto.MenuDTO;
import com.emond.mall.provider.system.enums.MenuType;
import com.emond.mall.provider.system.vo.MenuMetaVo;
import com.emond.mall.provider.system.vo.Routes;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {

    private static final String NOREDIRECT = "noredirect";
    private static final String INDEX = "index";
    private static final String LAYOUT = "Layout";

    private final static String NAME = "菜单";

    private final MenuRepository menuRepository;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository) {
        super(menuRepository, NAME);
        this.menuRepository = menuRepository;
    }

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Menu create(Menu resources) {
        if (menuRepository.existsByName(resources.getName())) {
            throw new EntityExistException("菜单名称", resources.getName());
        }

        if (StringUtils.isNotBlank(resources.getComponentName())
                && menuRepository.existsByComponentName(resources.getComponentName())) {
            throw new EntityExistException("组件名称", resources.getComponentName());
        }

        if (resources.getIFrame()) {
            String http = "http://", https = "https://";
            if (!(resources.getPath().toLowerCase().startsWith(http) || resources.getPath().toLowerCase().startsWith(https))) {
                throw new BadRequestException("外链必须以http://或者https://开头");
            }
        }
        return super.create(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<Long> ids) {
        Set<Menu> menuSet = new HashSet<>();
        for (Long id : ids) {
            List<Menu> menuList = this.findByPid(id);
            menuSet.add(this.findById(id));
            menuSet = this.getDeleteMenus(menuList, menuSet);
        }
        for (Menu menu : menuSet) {
            // menu相对于role是从表，不会删除中间表对应的数据
            roleService.untiedMenu(menu.getId());
            menuRepository.deleteById(menu.getId());
        }
    }

    private Set<Menu> getDeleteMenus(List<Menu> menuList, Set<Menu> menuSet) {
        for (Menu menu : menuList) {
            menuSet.add(menu);
            List<Menu> dbMenus = this.findByPid(menu.getId());
            if (ObjectUtils.isNotEmpty(dbMenus)) {
                getDeleteMenus(dbMenus, menuSet);
            }
        }
        return menuSet;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Menu update(Menu resources) {
        if (resources.getId().equals(resources.getPid())) {
            throw new BadRequestException("上级不能为自己");
        }

        if (resources.getIFrame()) {
            String http = "http://", https = "https://";
            if (!(resources.getPath().toLowerCase().startsWith(http) || resources.getPath().toLowerCase().startsWith(https))) {
                throw new BadRequestException("外链必须以http://或者https://开头");
            }
        }

        this.findById(resources.getId());

        if (menuRepository.existsByNameAndIdNot(resources.getName(), resources.getId())) {
            throw new EntityExistException("菜单名称", resources.getName());
        }

        if (StringUtils.isNotBlank(resources.getComponentName())
                && menuRepository.existsByComponentNameAndIdNot(resources.getComponentName(), resources.getId())) {
            throw new EntityExistException("组件名称", resources.getComponentName());
        }

        return super.update(resources);
    }


    @Override
    public List<Menu> findByRolesIdAndTypeInOrderBySortAsc(List<Role> roles) {

        List<Menu> menuAll = new ArrayList<>();
        for (Role role : roles) {
            List<Menu> menus = menuRepository.findByRolesIdAndTypeInOrderBySortAsc(role.getId()
                    , ArrayUtils.toArray(MenuType.CATALOGUE, MenuType.MENU));
            menuAll.addAll(menus);
        }
        return menuAll;
    }

    @Override
    public List<Routes> getRoutes() {
        User user = userService.findById(OAuth2Utils.getCurrentUserId());
        List<Menu> menuList = this.findByRolesIdAndTypeInOrderBySortAsc(roleService.findByUsersId(user.getId()));
        List<MenuDTO> trees = this.buildTree(menuList);
        return this.buildMenus(trees);
    }

    @Override
    public List<MenuDTO> buildTree(List<Menu> menus) {
        List<MenuDTO> menuDTOS = menuMapper.toDTO(menus);
        List<MenuDTO> trees = new ArrayList<>();
        Set<Long> ids = new HashSet<>();
        for (MenuDTO menuDTO : menuDTOS) {
            if (menuDTO.getPid() == 0) {
                trees.add(menuDTO);
            }
            for (MenuDTO child : menuDTOS) {
                if (child.getPid().equals(menuDTO.getId())) {
                    if (menuDTO.getChildren() == null) {
                        menuDTO.setChildren(new ArrayList<>());
                    }
                    menuDTO.getChildren().add(child);
                    ids.add(child.getId());
                }
            }
        }
        if (trees.size() == 0) {
            trees = menuDTOS.stream().filter(s -> !ids.contains(s.getId())).collect(Collectors.toList());
        }
        return trees;
    }

    @Override
    public List<Routes> buildMenus(List<MenuDTO> trees) {
        List<Routes> list = new LinkedList<>();
        trees.forEach(menuDTO -> {
                    if (menuDTO != null) {
                        List<MenuDTO> menuDTOList = menuDTO.getChildren();
                        Routes routes = new Routes();
                        routes.setName(StringUtils.isNotBlank(menuDTO.getComponentName()) ? menuDTO.getComponentName() : menuDTO.getName());
                        // 一级目录需要加斜杠，不然会报警告
                        routes.setPath(menuDTO.getPid() == 0 ? "/" + menuDTO.getPath() : menuDTO.getPath());
                        routes.setHidden(menuDTO.getHidden());
                        // 如果不是外链
                        if (!menuDTO.getIFrame()) {
                            if (menuDTO.getPid() == 0) {
                                routes.setComponent(StringUtils.isEmpty(menuDTO.getComponent()) ? "Layout" : menuDTO.getComponent());
                            } else if (StringUtils.isNotBlank(menuDTO.getComponent())) {
                                routes.setComponent(menuDTO.getComponent());
                            }
                        }
                        routes.setMeta(new MenuMetaVo(menuDTO.getName(), menuDTO.getIcon(), !menuDTO.getCache()));
                        if (ObjectUtils.isNotEmpty(menuDTOList)) {
                            routes.setAlwaysShow(true);
                            routes.setRedirect(NOREDIRECT);
                            routes.setChildren(buildMenus(menuDTOList));
                            // 处理是一级菜单并且没有子菜单的情况
                        } else if (menuDTO.getPid() == 0) {
                            Routes catalogue = new Routes();
                            catalogue.setMeta(routes.getMeta());
                            // 非外链
                            if (!menuDTO.getIFrame()) {
                                catalogue.setPath(INDEX);
                                catalogue.setName(routes.getName());
                                catalogue.setComponent(routes.getComponent());
                            } else {
                                catalogue.setPath(menuDTO.getPath());
                            }
                            routes.setName(null);
                            routes.setMeta(null);
                            routes.setComponent(LAYOUT);
                            List<Routes> children = new ArrayList<>();
                            children.add(catalogue);
                            routes.setChildren(children);
                        }
                        list.add(routes);
                    }
                }
        );
        return list;
    }


    @Override
    public List<ElTree> getMenuTree(List<Menu> resources) {
        List<ElTree> elTrees = new ArrayList<>();
        resources.forEach(menu -> {
            if (ObjectUtils.isNotEmpty(menu)) {
                List<Menu> menuList = menuRepository.findByPid(menu.getId());
                ElTree elTree = ElTree.of(menu.getId(),menu.getName());
                if (ObjectUtils.isNotEmpty(menuList)) {
                    elTree.setChildren(getMenuTree(menuList));
                }
                elTrees.add(elTree);
            }
        });
        return elTrees;
    }

    @Override
    public List<Menu> findByPid(Long pid) {
        return menuRepository.findByPid(pid);
    }
}
