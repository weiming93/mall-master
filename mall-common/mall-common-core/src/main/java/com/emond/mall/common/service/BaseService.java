package com.emond.mall.common.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

/**
 * 公共服务类
 * @author: Chen Weiming
 */
public interface BaseService <T>{

    /**
     * 分页查找
     * @param QueryCriteria 查询参数
     * @param pageable 分页参数
     * @return
     */
    Page<T> findPage(Object QueryCriteria,Pageable pageable);

    /**
     * 通过ID查找
     * @param id 实体ID
     * @return
     */
    T findById(Long id);

    /**
     * 新建实体
     * @param resource
     * @return
     */
    T create(T resource);

    /**
     * 更新实体
     * @param resource
     */
    T update(T resource);

    /**
     * 批量删除
     * @param ids 实体ID集合
     */
    void delete(Set<Long> ids);

    /**
     * 条件查找所有
     * @param QueryCriteria 查询参数
     * @return
     */
    List<T> findAll(Object QueryCriteria);
}
