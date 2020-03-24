package com.emond.mall.business.mapper;

import com.emond.mall.business.domain.Brand;
import com.emond.mall.common.mapper.BaseMapper;
import com.emond.mall.provider.goods.dto.BrandDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @description:
 * @author: Chen Weiming
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BrandMapper extends BaseMapper<Brand, BrandDTO> {
}
