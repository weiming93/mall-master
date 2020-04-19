package com.emond.mall.business.mapper;

import com.emond.mall.business.domain.Freight;
import com.emond.mall.common.mapper.BaseMapper;
import com.emond.mall.provider.setting.dto.FreightDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author: Chen Weiming
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FreightMapper extends BaseMapper<Freight, FreightDTO> {
}
