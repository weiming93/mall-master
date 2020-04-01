package com.emond.mall.business.service.impl;

import com.emond.mall.business.domain.Attribute;
import com.emond.mall.business.repository.AttributeRepository;
import com.emond.mall.business.service.AttributeService;
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
public class AttributeServiceImpl extends BaseServiceImpl<Attribute> implements AttributeService {

    private final static String NAME = "商品属性";

    private final AttributeRepository attributeRepository;


    @Autowired
    public AttributeServiceImpl(AttributeRepository attributeRepository) {
        super(attributeRepository, NAME);
        this.attributeRepository = attributeRepository;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Attribute create(Attribute resource) {
        if (attributeRepository.existsByName(resource.getName())){
            throw new EntityExistException(NAME,resource.getName());
        }
        return super.create(resource);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Attribute update(Attribute resource) {
        if (attributeRepository.existsByNameAndIdNot(resource.getName(),resource.getId())){
            throw new EntityExistException(NAME,resource.getName());
        }
        return super.update(resource);
    }

}
