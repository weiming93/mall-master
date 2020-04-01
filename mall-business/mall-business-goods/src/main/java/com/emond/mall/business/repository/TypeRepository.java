package com.emond.mall.business.repository;

import com.emond.mall.business.domain.Type;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 * @author Chen Weiming
 */
public interface TypeRepository extends JpaRepositoryImplementation<Type,Long> {
    /**
     * 判断商品类型是否存在
     * @param name  商品类型名称
     * @return  存在:true,不存在:false
     */
    boolean existsByName(String name);

    /**
     * 判断商品类型是否存在,排除指定ID
     * @param name  商品类型名称
     * @param id    商品类型ID
     * @return  存在:true,不存在:false
     */
    boolean existsByNameAndIdNot(String name, Long id);
//
//    /**
//     * 修改属性数量
//     * @param id 类型ID
//     * @param expected 期望值
//     * @param actual 实际值
//     * @return
//     */
//    @Modifying
//    @Query(value = "update type set attribute_count = :actual where id = :id and attribute_count = :expected",nativeQuery = true)
//    int modifyAttributeCount(@Param("id") Long id, @Param("expected")Integer expected, @Param("actual")Integer actual);
}
