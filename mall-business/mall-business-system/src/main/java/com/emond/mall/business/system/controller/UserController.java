package com.emond.mall.business.system.controller;

import com.emond.mall.business.system.domain.User;
import com.emond.mall.business.system.domain.UserAvatar;
import com.emond.mall.business.system.domain.UserProfile;
import com.emond.mall.business.system.mapper.UserMapper;
import com.emond.mall.business.system.query.UserQueryCriteria;
import com.emond.mall.business.system.service.UserService;
import com.emond.mall.provider.system.dto.UserDTO;
import com.emond.mall.provider.system.dto.UserPassDTO;
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
        return userMapper.toPage(userService.findPage(criteria, pageable));
    }

    @ApiOperation("创建用户")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(@Validated @RequestBody User resource) {
        return userMapper.toDTO(userService.create(resource));
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
    public void update(@Validated @RequestBody User resource) {
        userService.update(resource);
    }

    @ApiOperation("修改密码")
    @PatchMapping("pass")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePass(@RequestBody UserPassDTO userPassDTO){
        userService.updatePass(userPassDTO);
    }

    @ApiOperation("修改个人中心资料")
    @PatchMapping("profile")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProfile(@Validated @RequestBody UserProfile resource){
        userService.updateProfile(resource);
    }

    @ApiOperation("修改头像")
    @PatchMapping("avatar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAvatar(@Validated @RequestBody UserAvatar resource){
        userService.updateAvatar(resource);
    }
    
    @ApiOperation("通过ID查询用户")
    @GetMapping("{id}")
    public UserDTO findById(@PathVariable Long id){
        return userMapper.toDTO(userService.findById(id));
    }
}
