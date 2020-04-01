package com.emond.mall.common.mapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Collection;
import java.util.List;

/**
 * 基础转换类
 * @author: Chen Weiming
 */
public interface BaseMapper <S, T> {

    T toDTO(S source);

    List<T> toDTO(Collection<S> sources);

    S toEntity(T target);

    List<S> toEntity(Collection<T> targets);

    default Page<T> toPage(Page<S> page){
        List<S> content = page.getContent();
        List<T> targets = this.toDTO(content);
        return new PageImpl<T>(targets,page.getPageable(),page.getTotalElements());
    }

}
