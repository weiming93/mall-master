package com.emond.mall.business.system.mapper;

import com.emond.mall.business.system.domain.DictDetail;
import com.emond.mall.common.mapper.BaseMapper;
import com.emond.mall.provider.system.dto.DictDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author: Chen Weiming
 */
@Mapper(componentModel = "spring", uses = {DictMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictDetailMapper extends BaseMapper<DictDetail, DictDetailDTO> {
}
