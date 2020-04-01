package com.emond.mall.business.service;

import com.emond.mall.business.domain.Type;
import com.emond.mall.common.domain.ElTree;
import com.emond.mall.common.service.BaseService;

import java.util.List;

/**
 * @author Chen Weiming
 */
public interface TypeService extends BaseService<Type> {

    /**
     * 查询所有商品类型
     * @return
     */
    List<Type> findAll();

    /**
     * 获取级联属性
     * @return el-tree 树形控件
     */
    List<ElTree> getCascaderAttribute();

}
