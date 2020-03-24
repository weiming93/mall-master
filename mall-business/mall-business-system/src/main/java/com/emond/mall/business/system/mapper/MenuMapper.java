package com.emond.mall.business.system.mapper;


import com.emond.mall.business.system.domain.Menu;
import com.emond.mall.common.mapper.BaseMapper;
import com.emond.mall.provider.system.dto.MenuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @description: 菜单映射类
 * @author: Chen Weiming
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper extends BaseMapper<Menu, MenuDTO> {

}
