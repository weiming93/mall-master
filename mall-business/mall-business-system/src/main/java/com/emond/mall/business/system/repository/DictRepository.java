package com.emond.mall.business.system.repository;


import com.emond.mall.business.system.domain.Dict;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface DictRepository extends JpaRepositoryImplementation<Dict,Long> {
    /**
     * 判断字典是否存在
     * @param name 字典名称
     * @return
     */
    boolean existsByName(String name);

    /**
     * 判断字典是否存在,排除指定ID
     * @param name 字典名称
     * @param id 字典ID
     * @return 存在:true,不存在:false
     */
    boolean existsByNameAndIdNot(String name, Long id);
}