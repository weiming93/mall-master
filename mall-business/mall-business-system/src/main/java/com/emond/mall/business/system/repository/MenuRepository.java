package com.emond.mall.business.system.repository;


import com.emond.mall.business.system.domain.Menu;
import com.emond.mall.provider.system.enums.MenuType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu,Long>, JpaSpecificationExecutor<Menu> {

    boolean existsByName(String name);

    List<Menu> findByRolesIdAndTypeInOrderBySortAsc(Long id, MenuType[] menuTypes);

    List<Menu> findByPid(Long pid);

    boolean existsByComponentName(String componentName);

    boolean existsByNameAndIdNot(String name, Long id);

    boolean existsByComponentNameAndIdNot(String componentName, Long id);
}
