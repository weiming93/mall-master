package com.emond.mall.business.repository;

import com.emond.mall.business.domain.Brand;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 * @author Chen Weiming
 */
public interface BrandRepository extends JpaRepositoryImplementation<Brand,Long> {
    /**
     * 判断品牌是否存在
     * @param name  品牌名称
     * @return  存在:true,不存在:false
     */
    boolean existsByName(String name);

    /**
     * 判断品牌是否存在,排除指定ID
     * @param name  品牌名称
     * @param id    品牌ID
     * @return  存在:true,不存在:false
     */
    boolean existsByNameAndIdNot(String name, Long id);
}
