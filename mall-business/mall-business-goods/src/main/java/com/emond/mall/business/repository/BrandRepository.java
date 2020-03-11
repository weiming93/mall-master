package com.emond.mall.business.repository;

import com.emond.mall.business.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BrandRepository extends JpaRepository<Brand,Long> {
}
