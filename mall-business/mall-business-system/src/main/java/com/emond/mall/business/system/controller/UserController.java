package com.emond.mall.business.system.controller;

import com.emond.mall.business.system.domain.User;
import com.emond.mall.business.system.domain.query.UserQueryCriteria;
import com.emond.mall.business.system.mapper.UserMapper;
import com.emond.mall.business.system.service.UserService;
import com.emond.mall.common.domain.Create;
import com.emond.mall.common.domain.Update;
import com.emond.mall.provider.system.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {


    private final UserService userService;

    private final UserMapper userMapper;

    @ApiOperation("查询用户")
    @GetMapping
    public Page<UserDTO> getUserPage(UserQueryCriteria criteria, Pageable pageable) {
        return userMapper.toPage(userService.getUserPage(criteria, pageable));
    }

    @ApiOperation("创建用户")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(@Validated(Create.class) @RequestBody User resources) {
        return userMapper.toDTO(userService.create(resources));
    }

    @ApiOperation("删除用户")
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestBody Set<Long> ids) {
        userService.delete(ids);
    }

    @ApiOperation("修改用户")
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Validated(Update.class) @RequestBody User resources) {
        userService.update(resources);
    }

}
