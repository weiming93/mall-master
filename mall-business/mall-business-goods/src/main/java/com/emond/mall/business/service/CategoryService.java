package com.emond.mall.business.service;

import com.emond.mall.business.domain.Category;
import com.emond.mall.common.service.BaseService;

import java.util.List;

/**
 * @author: Chen Weiming
 */
public interface CategoryService extends BaseService<Category> {
    /**
     * 查询一级分类
     * @return
     */
    List<Category> findFirstLevel();

}
