//package com.emond.mall.user.controller;
//
//import com.emond.mall.provider.domain.User;
//import com.emond.mall.user.service.UserService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("/api/user")
//@Tag(name = "系统：用户管理")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @Operation(summary = "新增用户")
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("@el.check('user:create')")
//    public Mono<User> create(@Valid @RequestBody User user){
//        return userService.create(user);
//    }
//}