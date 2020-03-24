package com.emond.mall.business.service.impl;

import com.emond.mall.business.domain.Brand;
import com.emond.mall.business.query.BrandQueryCriteria;
import com.emond.mall.business.repository.BrandRepository;
import com.emond.mall.business.service.BrandService;
import com.emond.mall.common.exception.BadRequestException;
import com.emond.mall.common.exception.EntityExistException;
import com.emond.mall.common.exception.ResourceNotFoundException;
import com.emond.mall.common.utils.QueryHelp;
import com.emond.mall.common.utils.RegexpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BrandServiceImpl implements BrandService {

    private final static String BRAND = "品牌";
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand findById(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(BRAND, "ID", id));
    }

    @Override
    public Page<Brand> findPage(BrandQueryCriteria criteria, Pageable pageable) {
        return brandRepository.findAll((root, criteriaQuery, criteriaBuilder)
                -> QueryHelp.getPredicate(root, criteria, criteriaBuilder),pageable);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Brand create(Brand resource) {
        validLetter(resource.getLetter());
        if (brandRepository.existsByName(resource.getName())){
            throw new EntityExistException(BRAND,resource.getName());
        }
        return brandRepository.save(resource);
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
    public void update(Brand resource) {
        validLetter(resource.getLetter());
        if (brandRepository.existsByNameAndIdNot(resource.getName(),resource.getId())){
            throw new EntityExistException(BRAND,resource.getName());
        }
        brandRepository.save(resource);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<Long> ids) {
        for (Long id : ids) {
            brandRepository.deleteById(id);
        }
    }


}
