package com.emond.mall.business.user.controller;

import com.emond.mall.business.user.service.UserService;
import com.emond.mall.common.domain.Create;
import com.emond.mall.provider.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyAuthority('user:create')")
    public User create(@Validated(Create.class) @RequestBody User user){
        return userService.create(user);
    }
}
