package com.emond.mall.business.service.impl;

import com.emond.mall.business.domain.Parameter;
import com.emond.mall.business.repository.ParameterRepository;
import com.emond.mall.business.service.ParameterService;
import com.emond.mall.common.exception.EntityExistException;
import com.emond.mall.common.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Chen Weiming
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ParameterServiceImpl extends BaseServiceImpl<Parameter> implements ParameterService {

    private final static String NAME = "商品参数";

    private final ParameterRepository parameterRepository;

    @Autowired
    public ParameterServiceImpl(ParameterRepository parameterRepository) {
        super(parameterRepository, NAME);
        this.parameterRepository = parameterRepository;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Parameter create(Parameter resource) {
        if (parameterRepository.existsByName(resource.getName())){
            throw new EntityExistException(NAME,resource.getName());
        }
        return super.create(resource);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Parameter update(Parameter resource) {
        if (parameterRepository.existsByNameAndIdNot(resource.getName(),resource.getId())){
            throw new EntityExistException(NAME,resource.getName());
        }
        return super.update(resource);
    }

}
