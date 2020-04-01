package com.emond.mall.business.mapper;

import com.emond.mall.business.domain.Type;
import com.emond.mall.common.mapper.BaseMapper;
import com.emond.mall.provider.goods.dto.TypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author: Chen Weiming
 */
@Mapper(componentModel = "spring", uses = {AttributeMapper.class,ParameterMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TypeMapper extends BaseMapper<Type, TypeDTO> {
}
