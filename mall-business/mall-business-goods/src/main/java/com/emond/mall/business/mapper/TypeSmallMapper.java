package com.emond.mall.business.mapper;

import com.emond.mall.business.domain.Type;
import com.emond.mall.common.mapper.BaseMapper;
import com.emond.mall.provider.goods.dto.TypeSmallDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author: Chen Weiming
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TypeSmallMapper extends BaseMapper<Type, TypeSmallDTO> {
}
