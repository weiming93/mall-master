package com.emond.mall.business.system.service.impl;

import com.emond.mall.business.system.domain.Dict;
import com.emond.mall.business.system.domain.query.DictQueryCriteria;
import com.emond.mall.business.system.repository.DictRepository;
import com.emond.mall.business.system.service.DictService;
import com.emond.mall.common.exception.ResourceNotFoundException;
import com.emond.mall.common.utils.QueryHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: Chen Weiming
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DictServiceImpl implements DictService {
    @Autowired
    private DictRepository dictRepository;

    @Override
    public Page<Dict> getDictPage(DictQueryCriteria criteria, Pageable pageable) {
        return dictRepository.findAll((root, query, cb)
                -> QueryHelp.getPredicate(root, criteria, cb), pageable);
    }

    @Override
    public List<Dict> findAll(DictQueryCriteria criteria) {
        return dictRepository.findAll((root, query, cb) -> QueryHelp.getPredicate(root, criteria, cb));
    }

    @Override
    public Dict findById(Long id) {
        return dictRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("字典", "ID", id));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Dict create(Dict resources) {
        return dictRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Dict resources) {
        this.findById(resources.getId());
        dictRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<Long> ids) {
        for (Long id : ids) {
            dictRepository.deleteById(id);
        }
    }
}
