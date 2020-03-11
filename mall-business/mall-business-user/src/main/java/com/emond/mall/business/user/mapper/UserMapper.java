package com.emond.mall.business.user.mapper;

import com.emond.mall.common.mapper.BaseMapper;
import com.emond.mall.business.user.domain.User;
import com.emond.mall.provider.user.dto.UserDTO;
import org.mapstruct.Mapper;

/**
 * @description: 用户映射类
 * @author: Emond Chan
 */
@Mapper(componentModel = "spring", uses = RoleMapper.class)
public interface UserMapper extends BaseMapper<User, UserDTO> {

}
