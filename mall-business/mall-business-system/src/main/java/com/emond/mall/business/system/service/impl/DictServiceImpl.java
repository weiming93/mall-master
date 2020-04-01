package com.emond.mall.business.system.service.impl;

import com.emond.mall.business.system.domain.Dict;
import com.emond.mall.business.system.repository.DictRepository;
import com.emond.mall.business.system.service.DictService;
import com.emond.mall.common.exception.EntityExistException;
import com.emond.mall.common.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: Chen Weiming
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DictServiceImpl extends BaseServiceImpl<Dict> implements DictService {

    private final static String NAME = "字典详情";

    private final DictRepository dictRepository;

    public DictServiceImpl(DictRepository dictRepository) {
        super(dictRepository, NAME);
        this.dictRepository = dictRepository;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Dict create(Dict resource) {
        if (dictRepository.existsByName(resource.getName())){
            throw new EntityExistException(NAME,resource.getName());
        }
        return super.create(resource);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Dict update(Dict resource) {
        if (dictRepository.existsByNameAndIdNot(resource.getName(),resource.getId())){
            throw new EntityExistException(NAME,resource.getName());
        }
        return super.update(resource);
    }

}
