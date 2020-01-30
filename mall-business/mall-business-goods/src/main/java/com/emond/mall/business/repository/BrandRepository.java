package com.emond.mall.business.repository;

import th.co.geniustree.springdata.jpa.repository.JpaSpecificationExecutorWithProjection;

public interface BrandRepository extends JpaRepository<Brand,Long>, JpaSpecificationExecutorWithProjection {
}
