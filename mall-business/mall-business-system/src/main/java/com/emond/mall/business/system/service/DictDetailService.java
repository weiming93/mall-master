package com.emond.mall.business.system.service;

import com.emond.mall.business.system.domain.DictDetail;
import com.emond.mall.business.system.domain.query.DictDetailQueryCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @description:
 * @author: Chen Weiming
 */
public interface DictDetailService {

    DictDetail findById(Long id);

    DictDetail create(DictDetail resources);

    void update(DictDetail resources);

    void delete(Long id);

    Page<DictDetail> getPage(DictDetailQueryCriteria criteria, Pageable pageable);
}
