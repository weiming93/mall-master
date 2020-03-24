package com.emond.mall.business.system.mapper;

import com.emond.mall.business.system.domain.User;
import com.emond.mall.common.mapper.BaseMapper;
import com.emond.mall.provider.system.dto.UserDTO;
import org.mapstruct.Mapper;

/**
 * @description: 用户映射类
 * @author: Chen Weiming
 */
@Mapper(componentModel = "spring", uses = RoleMapper.class)
public interface UserMapper extends BaseMapper<User, UserDTO> {

}
