package com.emond.mall.business.service.impl;

import com.emond.mall.business.domain.Brand;
import com.emond.mall.business.repository.BrandRepository;
import com.emond.mall.business.service.BrandService;
import com.emond.mall.common.exception.BadRequestException;
import com.emond.mall.common.exception.EntityExistException;
import com.emond.mall.common.service.impl.BaseServiceImpl;
import com.emond.mall.common.utils.RegexpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/**
 * @author Chen Weiming
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BrandServiceImpl extends BaseServiceImpl<Brand> implements BrandService {

    private final static String NAME = "品牌";

    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        super(brandRepository, NAME);
        this.brandRepository = brandRepository;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Brand create(Brand resource) {
        validLetter(resource.getLetter());
        if (brandRepository.existsByName(resource.getName())){
            throw new EntityExistException(NAME,resource.getName());
        }
        return super.create(resource);
    }

    /**
     * 验证首字母
     * @param letter
     */
    private void validLetter(String letter) {
        String letterRge = "[A-Z]";
        if (RegexpUtils.notMatch(letterRge,letter)){
            throw new BadRequestException("品牌首字符必须是一位大写字母");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Brand update(Brand resource) {
        validLetter(resource.getLetter());
        if (brandRepository.existsByNameAndIdNot(resource.getName(),resource.getId())){
            throw new EntityExistException(NAME,resource.getName());
        }
        return super.update(resource);
    }

}
