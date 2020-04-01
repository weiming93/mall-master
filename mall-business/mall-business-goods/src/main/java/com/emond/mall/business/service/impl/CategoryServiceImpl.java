package com.emond.mall.business.service.impl;

import com.emond.mall.business.domain.Category;
import com.emond.mall.business.repository.CategoryRepository;
import com.emond.mall.business.service.CategoryService;
import com.emond.mall.common.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Chen Weiming
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

    private final static String NAME = "商品分类";

    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl( CategoryRepository categoryRepository) {
        super(categoryRepository, NAME);
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findFirstLevel() {
        return categoryRepository.findByPid(0L);
    }
}
