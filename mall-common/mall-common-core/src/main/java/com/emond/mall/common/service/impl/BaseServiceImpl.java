package com.emond.mall.common.service.impl;

import com.emond.mall.common.exception.ResourceNotFoundException;
import com.emond.mall.common.service.BaseService;
import com.emond.mall.common.utils.QueryHelp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * 公共服务类实现类
 * @author: Chen Weiming
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    private JpaRepositoryImplementation<T,Long> jpaRepositoryImplementation;

    private String domainName;

    public BaseServiceImpl(JpaRepositoryImplementation jpaRepositoryImplementation, String domainName) {
        this.jpaRepositoryImplementation = jpaRepositoryImplementation;
        this.domainName = domainName;
    }

    @Override
    public Page<T> findPage(Object criteria, Pageable pageable) {
        return jpaRepositoryImplementation.findAll((root, criteriaQuery, criteriaBuilder)
                -> QueryHelp.getPredicate(root, criteria, criteriaBuilder),pageable);
    }

    @Override
    public T findById(Long id) {
        return jpaRepositoryImplementation.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(domainName, "ID", id));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public T create(T resource) {
        return jpaRepositoryImplementation.save(resource);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public T update(T resource) {
        return jpaRepositoryImplementation.save(resource);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<Long> ids) {
        for (Long id : ids) {
            jpaRepositoryImplementation.deleteById(id);
        }
    }

    @Override
    public List<T> findAll(Object criteria) {
        return jpaRepositoryImplementation.findAll((root, criteriaQuery, criteriaBuilder)
                -> QueryHelp.getPredicate(root, criteria, criteriaBuilder));
    }
}
