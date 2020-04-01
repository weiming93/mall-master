package com.emond.mall.business.system.service.impl;

import com.emond.mall.business.system.domain.DictDetail;
import com.emond.mall.business.system.repository.DictDetailRepository;
import com.emond.mall.business.system.service.DictDetailService;
import com.emond.mall.common.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: Chen Weiming
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DictDetailServiceImpl extends BaseServiceImpl<DictDetail> implements DictDetailService {

    private final static String NAME = "字典详情";

    private final DictDetailRepository dictDetailRepository;

    @Autowired
    public DictDetailServiceImpl(DictDetailRepository dictDetailRepository) {
        super(dictDetailRepository, NAME);
        this.dictDetailRepository = dictDetailRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        dictDetailRepository.deleteById(id);
    }


}
