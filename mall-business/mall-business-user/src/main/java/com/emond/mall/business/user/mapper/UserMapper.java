package com.emond.mall.business.user.mapper;

import com.emond.mall.common.mapper.BaseMapper;
import com.emond.mall.provider.user.domain.User;
import com.emond.mall.provider.user.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @description: 用户映射类
 * @author: Emond Chan
 */
@Mapper(componentModel = "spring", uses = RoleMapper.class)
public interface UserMapper extends BaseMapper<User, UserDto> {

}
