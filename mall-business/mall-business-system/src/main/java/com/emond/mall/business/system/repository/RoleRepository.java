package com.emond.mall.business.system.repository;

import com.emond.mall.business.system.domain.Role;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;

public interface RoleRepository extends JpaRepositoryImplementation<Role,Long> {

    Boolean existsByName(String roleName);
    /**
     * 根据用户ID查询
     * @param userId 用户ID
     * @return
     */
    List<Role> findByUsersId(Long userId);

    /**
     * 解绑角色菜单
     * @param id 菜单ID
     */
    @Modifying
    @Query(value = "delete from roles_menus where menu_id = ?1",nativeQuery = true)
    void untiedMenu(Long id);
}
