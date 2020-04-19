package com.emond.mall.business.service.impl;

import com.emond.mall.business.domain.Freight;
import com.emond.mall.business.repository.FreightRepository;
import com.emond.mall.business.service.FreightService;
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
public class FreightServiceImpl extends BaseServiceImpl<Freight> implements FreightService {

    private final static String NAME = "地区";

    private final FreightRepository freightRepository;

    @Autowired
    public FreightServiceImpl(FreightRepository freightRepository) {
        super(freightRepository, NAME);
        this.freightRepository = freightRepository;
    }

    @Override
    public Freight create(Freight resource) {
        resource.setEnabled(true);
        return super.create(resource);
    }

    @Override
    public Freight update(Freight resource) {
        return super.update(resource);
    }
}
