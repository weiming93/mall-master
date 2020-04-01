package com.emond.mall.business.system.repository;


import com.emond.mall.business.system.domain.Menu;
import com.emond.mall.provider.system.enums.MenuType;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;

public interface MenuRepository extends JpaRepositoryImplementation<Menu,Long> {

    boolean existsByName(String name);

    List<Menu> findByRolesIdAndTypeInOrderBySortAsc(Long id, MenuType[] menuTypes);

    List<Menu> findByPid(Long pid);

    boolean existsByComponentName(String componentName);

    boolean existsByNameAndIdNot(String name, Long id);

    boolean existsByComponentNameAndIdNot(String componentName, Long id);
}
