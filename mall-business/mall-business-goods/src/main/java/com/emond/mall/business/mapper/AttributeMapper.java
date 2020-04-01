package com.emond.mall.business.mapper;

import com.emond.mall.business.domain.Attribute;
import com.emond.mall.common.mapper.BaseMapper;
import com.emond.mall.provider.goods.dto.AttributeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author: Chen Weiming
 */
@Mapper(componentModel = "spring", uses = {TypeSmallMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AttributeMapper extends BaseMapper<Attribute, AttributeDTO> {
}
