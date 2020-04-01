package com.emond.mall.business.repository;

import com.emond.mall.business.domain.Parameter;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 * @author Chen Weiming
 */
public interface ParameterRepository extends JpaRepositoryImplementation<Parameter,Long> {
    /**
     * 判断商品参数是否存在
     * @param name  商品参数名称
     * @return  存在:true,不存在:false
     */
    boolean existsByName(String name);

    /**
     * 判断商品参数是否存在,排除指定ID
     * @param name  商品参数名称
     * @param id    商品参数ID
     * @return  存在:true,不存在:false
     */
    boolean existsByNameAndIdNot(String name, Long id);
}
