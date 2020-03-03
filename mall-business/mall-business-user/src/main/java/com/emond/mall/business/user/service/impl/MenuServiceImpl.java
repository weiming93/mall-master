package com.emond.mall.business.user.service.impl;

import com.emond.mall.business.user.mapper.MenuMapper;
import com.emond.mall.business.user.repository.MenuRepository;
import com.emond.mall.business.user.service.MenuService;
import com.emond.mall.common.exception.EntityExistException;
import com.emond.mall.common.exception.ResourceNotFoundException;
import com.emond.mall.provider.user.domain.Menu;
import com.emond.mall.provider.user.domain.MenuType;
import com.emond.mall.provider.user.dto.MenuDTO;
import com.emond.mall.provider.user.dto.RoleDTO;
import com.emond.mall.provider.user.vo.MenuMetaVo;
import com.emond.mall.provider.user.vo.MenuVo;
import io.netty.util.internal.ObjectUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class MenuServiceImpl implements MenuService {

    private static final String NOREDIRECT = "noredirect";
    private static final String INDEX = "index";
    private static final String LAYOUT = "Layout";

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Menu create(Menu Menu) {
        if(menuRepository.existsByName(Menu.getName())){
            throw new EntityExistException("菜单",Menu.getName());
        }
        return menuRepository.save(Menu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        menuRepository.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Menu menu) {
        this.findById(menu.getId());
        menuRepository.save(menu);
    }

    @Override
    public Menu findById(Long id) {
        return menuRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("菜单","ID",id));
    }

    @Override
    public List<MenuDTO> findByRolesIdAndTypeInOrderBySortAsc(List<RoleDTO> roles) {

        List<Menu> menuAll = new ArrayList<>();
        for (RoleDTO role : roles) {
            List<Menu> menus = menuRepository.findByRolesIdAndTypeInOrderBySortAsc(role.getId()
                    , ArrayUtils.toArray(MenuType.CATALOGUE,MenuType.MENU));
            menuAll.addAll(menus);
        }
        return menuMapper.toDTO(menuAll);
    }

    @Override
    public List<MenuDTO> buildTree(List<MenuDTO> menuDTOList) {
        List<MenuDTO> trees = new ArrayList<>();
        Set<Long> ids = new HashSet<>();
        for (MenuDTO menuDTO : menuDTOList) {
            if (menuDTO.getPid() == 0) {
                trees.add(menuDTO);
            }
            for (MenuDTO child : menuDTOList) {
                if (child.getPid().equals(menuDTO.getId())) {
                    if (menuDTO.getChildren() == null) {
                        menuDTO.setChildren(new ArrayList<>());
                    }
                    menuDTO.getChildren().add(child);
                    ids.add(child.getId());
                }
            }
        }
        if(trees.size() == 0){
            trees = menuDTOList.stream().filter(s -> !ids.contains(s.getId())).collect(Collectors.toList());
        }
        return trees;
    }

    @Override
    public List<MenuVo> buildMenus(List<MenuDTO> trees) {
        List<MenuVo> list = new LinkedList<>();
        trees.forEach(menuDTO -> {
                    if (menuDTO!=null){
                        List<MenuDTO> menuDTOList = menuDTO.getChildren();
                        MenuVo menuVo = new MenuVo();
                        menuVo.setName(StringUtils.isNotBlank(menuDTO.getComponentName())  ? menuDTO.getComponentName() : menuDTO.getName());
                        // 一级目录需要加斜杠，不然会报警告
                        menuVo.setPath(menuDTO.getPid() == 0 ? File.separator + menuDTO.getPath() :menuDTO.getPath());
                        menuVo.setHidden(menuDTO.getHidden());
                        // 如果不是外链
                        if(!menuDTO.getIFrame()){
                            if(menuDTO.getPid() == 0){
                                menuVo.setComponent(StringUtils.isEmpty(menuDTO.getComponent())?"Layout":menuDTO.getComponent());
                            }else if(StringUtils.isNotBlank(menuDTO.getComponent())){
                                menuVo.setComponent(menuDTO.getComponent());
                            }
                        }
                        menuVo.setMeta(new MenuMetaVo(menuDTO.getName(),menuDTO.getIcon(),!menuDTO.getCache()));
                        if(ObjectUtils.isNotEmpty(menuDTOList)){
                            menuVo.setAlwaysShow(true);
                            menuVo.setRedirect(NOREDIRECT);
                            menuVo.setChildren(buildMenus(menuDTOList));
                            // 处理是一级菜单并且没有子菜单的情况
                        } else if(menuDTO.getPid() == 0){
                            MenuVo catalogue = new MenuVo();
                            catalogue.setMeta(menuVo.getMeta());
                            // 非外链
                            if(!menuDTO.getIFrame()){
                                catalogue.setPath(INDEX);
                                catalogue.setName(menuVo.getName());
                                catalogue.setComponent(menuVo.getComponent());
                            } else {
                                catalogue.setPath(menuDTO.getPath());
                            }
                            menuVo.setName(null);
                            menuVo.setMeta(null);
                            menuVo.setComponent(LAYOUT);
                            List<MenuVo> children = new ArrayList<>();
                            children.add(catalogue);
                            menuVo.setChildren(children);
                        }
                        list.add(menuVo);
                    }
                }
        );
        return list;
    }
}
