package com.emond.mall.business.mapper;

import com.emond.mall.business.domain.Parameter;
import com.emond.mall.common.mapper.BaseMapper;
import com.emond.mall.provider.goods.dto.ParameterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author: Chen Weiming
 */
@Mapper(componentModel = "spring", uses = {TypeSmallMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE ,implementationName = "<CLASS_NAME>implements")
public interface ParameterMapper extends BaseMapper<Parameter, ParameterDTO> {
}
