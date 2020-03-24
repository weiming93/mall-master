package com.emond.mall.business.system.mapper;

import com.emond.mall.business.system.domain.Dict;
import com.emond.mall.common.mapper.BaseMapper;
import com.emond.mall.provider.system.dto.DictDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @description:
 * @author: Chen Weiming
 */
@Mapper(componentModel = "spring",uses = {DictDetailMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictMapper extends BaseMapper<Dict, DictDTO> {
}
