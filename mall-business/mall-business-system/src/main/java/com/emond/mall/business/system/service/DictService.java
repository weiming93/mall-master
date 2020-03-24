package com.emond.mall.business.system.service;

import com.emond.mall.business.system.domain.Dict;
import com.emond.mall.business.system.domain.query.DictQueryCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: Chen Weiming
 */
public interface DictService {

    Page<Dict> getDictPage(DictQueryCriteria criteria, Pageable pageable);

    List<Dict> findAll(DictQueryCriteria criteria);

    Dict findById(Long id);

    Dict create(Dict resources);

    void update(Dict resources);

    void delete(Set<Long> id);



}
