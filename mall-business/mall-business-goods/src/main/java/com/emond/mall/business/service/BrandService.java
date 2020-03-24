package com.emond.mall.business.service;

import com.emond.mall.business.domain.Brand;
import com.emond.mall.business.query.BrandQueryCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface BrandService {

    Page<Brand> findPage(BrandQueryCriteria criteria, Pageable pageable);

    Brand findById(Long id);

    Brand create(Brand resource);

    void update(Brand resource);

    void delete(Set<Long> ids);
}
