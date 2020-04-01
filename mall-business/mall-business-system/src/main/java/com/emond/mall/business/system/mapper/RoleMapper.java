package com.emond.mall.business.system.mapper;

import com.emond.mall.business.system.domain.Role;
import com.emond.mall.common.mapper.BaseMapper;
import com.emond.mall.provider.system.dto.RoleDTO;
import org.mapstruct.Mapper;

/**
 *   角色映射类
 * @author: Chen Weiming
 */
@Mapper(componentModel = "spring", uses = {MenuMapper.class})
public interface RoleMapper extends BaseMapper<Role, RoleDTO> {

}
