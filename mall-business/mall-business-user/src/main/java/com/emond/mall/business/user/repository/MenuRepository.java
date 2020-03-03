package com.emond.mall.business.user.repository;


import com.emond.mall.provider.user.domain.Menu;
import com.emond.mall.provider.user.domain.MenuType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu,Long> {

    boolean existsByName(String name);

    List<Menu> findByRolesIdAndTypeInOrderBySortAsc(Long id, MenuType[] menuTypes);
}
