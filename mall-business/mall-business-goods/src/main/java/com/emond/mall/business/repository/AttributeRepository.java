package com.emond.mall.business.repository;

import com.emond.mall.business.domain.Attribute;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 * @author Chen Weiming
 */
public interface AttributeRepository extends JpaRepositoryImplementation<Attribute,Long> {
    /**
     * 判断商品属性是否存在
     * @param name  商品属性名称
     * @return  存在:true,不存在:false
     */
    boolean existsByName(String name);

    /**
     * 判断商品属性是否存在,排除指定ID
     * @param name  商品属性名称
     * @param id    商品属性ID
     * @return  存在:true,不存在:false
     */
    boolean existsByNameAndIdNot(String name, Long id);
}
