package com.emond.mall.business.repository;

import com.emond.mall.business.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BrandRepository extends JpaRepository<Brand,Long>, JpaSpecificationExecutor<Brand> {
    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, Long id);
}
