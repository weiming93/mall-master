package com.emond.mall.business.system.service;


import com.emond.mall.business.system.domain.Role;
import com.emond.mall.common.service.BaseService;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Chen Weiming
 */
public interface RoleService extends BaseService<Role> {
    /**
     * 根据用户ID查询
     * @param userId
     * @return
     */
    List<Role> findByUsersId(Long userId);

    /**
     * 获取登录用户的最小级别
     * @return /
     */
    Integer getLevels(Integer level);

    /**
     * 角色绑定菜单
     * @param resources
     */
    void updateMenu(Role resources);

    /**
     * 解绑角色菜单
     * @param id
     */
    void untiedMenu(Long id);

    List<Role> findAll(Pageable pageable);
}
