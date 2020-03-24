package com.emond.mall.common.repository;

import com.emond.mall.common.exception.ResourceNotFoundException;
import io.swagger.annotations.ApiModel;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: 通用JpaRepository的实现类
 * @author: Chen Weiming
 */

public class CommonJpaRepository<T,ID> extends SimpleJpaRepository<T,ID> {
    private final JpaEntityInformation<T, ?> entityInformation;
    private final EntityManager em;

    @Autowired
    public CommonJpaRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityInformation = entityInformation;
        this.em = entityManager;
    }

    /**
     * 通用save方法 ：新增/选择性更新
     */
    @Override
    @Transactional
    public <S extends T> S save(S entity) {
        //获取ID
        ID entityId = (ID) entityInformation.getId(entity);

        if (ObjectUtils.isEmpty(entityId)) {
            return super.save(entity);
        } else {
            String modelName = "资源";
            ApiModel apiModel = entity.getClass().getAnnotation(ApiModel.class);
            if (ObjectUtils.isNotEmpty(apiModel) && StringUtils.isNotBlank(apiModel.value())){
                modelName = apiModel.value();
            }
            final String fModelName = modelName;
            //获取最新对象
            T target = this.findById(entityId)
                    .orElseThrow(() -> new ResourceNotFoundException(fModelName,"ID",entityId));
            //获取空属性并处理成null
            String[] nullProperties = getNullProperties(entity);
            //将非空属性覆盖到最新对象
            BeanUtils.copyProperties(entity, target, nullProperties);
            return this.em.merge(entity);
        }
    }

    /**
     * 获取对象的空属性
     */
    private static String[] getNullProperties(Object src) {
        //1.获取Bean
        BeanWrapper srcBean = new BeanWrapperImpl(src);
        //2.获取Bean的属性描述
        PropertyDescriptor[] pds = srcBean.getPropertyDescriptors();
        //3.获取Bean的空属性
        Set<String> properties = new HashSet<>();
        for (PropertyDescriptor propertyDescriptor : pds) {
            String propertyName = propertyDescriptor.getName();
            Object propertyValue = srcBean.getPropertyValue(propertyName);
            if (ObjectUtils.isEmpty(propertyValue)) {
                srcBean.setPropertyValue(propertyName, null);
                properties.add(propertyName);
            }
        }
        return properties.toArray(new String[0]);
    }
}
