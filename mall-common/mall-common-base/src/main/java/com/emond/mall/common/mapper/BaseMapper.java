package com.emond.mall.common.mapper;

import java.util.Collection;
import java.util.List;

/**
 * @description: 基础转换类
 * @author: Emond Chan
 */
public interface BaseMapper <S, T> {

    T toDto(S source);

    List<T> toDto(Collection<S> sources);

    S toEntity(T target);

    List<S> toEntity(Collection<T> targets);
}
