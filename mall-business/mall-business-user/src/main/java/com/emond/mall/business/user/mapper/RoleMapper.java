package com.emond.mall.business.user.mapper;

import com.emond.mall.common.mapper.BaseMapper;
import com.emond.mall.business.user.domain.Role;
import com.emond.mall.provider.user.dto.RoleDTO;
import org.mapstruct.Mapper;

/**
 * @description:   角色映射类
 * @author: Emond Chan
 */
@Mapper(componentModel = "spring")
public interface RoleMapper extends BaseMapper<Role, RoleDTO> {
}
