package com.emond.mall.business.repository;

import com.emond.mall.provider.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import th.co.geniustree.springdata.jpa.repository.JpaSpecificationExecutorWithProjection;

public interface BrandRepository extends JpaRepository<Brand,Long>, JpaSpecificationExecutorWithProjection {
}
