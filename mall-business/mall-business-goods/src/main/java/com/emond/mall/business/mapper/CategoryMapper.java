package com.emond.mall.business.mapper;

import com.emond.mall.business.domain.Category;
import com.emond.mall.common.mapper.BaseMapper;
import com.emond.mall.provider.goods.dto.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author: Chen Weiming
 */
@Mapper(componentModel = "spring", uses = {AttributeMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper extends BaseMapper<Category, CategoryDTO> {

}
