package com.emond.mall.business.user.mapper;

import com.emond.mall.common.mapper.BaseMapper;
import com.emond.mall.provider.user.domain.Menu;
import com.emond.mall.provider.user.dto.MenuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @description: TODO
 * @author: Emond Chan
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper extends BaseMapper<Menu, MenuDTO> {

}
