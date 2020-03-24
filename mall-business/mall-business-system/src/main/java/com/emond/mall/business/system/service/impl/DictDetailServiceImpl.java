package com.emond.mall.business.system.service.impl;

import com.emond.mall.business.system.domain.DictDetail;
import com.emond.mall.business.system.domain.query.DictDetailQueryCriteria;
import com.emond.mall.business.system.repository.DictDetailRepository;
import com.emond.mall.business.system.service.DictDetailService;
import com.emond.mall.common.exception.ResourceNotFoundException;
import com.emond.mall.common.utils.QueryHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: Chen Weiming
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DictDetailServiceImpl implements DictDetailService {
    @Autowired
    private DictDetailRepository dictDetailRepository;


    @Override
    public DictDetail findById(Long id) {
        return dictDetailRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("字典详情", "ID", id));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DictDetail create(DictDetail resources) {
        return dictDetailRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(DictDetail resources) {
        this.findById(resources.getId());
        dictDetailRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        dictDetailRepository.deleteById(id);
    }

    @Override
    public Page<DictDetail> getPage(DictDetailQueryCriteria criteria, Pageable pageable) {
        return dictDetailRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
    }
}
