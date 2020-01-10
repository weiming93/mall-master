package com.blueocean.mall.provider.controller;


import com.blueocean.mall.common.security.core.JWTUtil;
import com.blueocean.mall.provider.payload.dto.LoginDto;
import com.blueocean.mall.provider.service.UserService;
import com.blueocean.mall.provider.utils.ModelMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "系统：登录")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private JWTUtil jwtUtil;

    @Operation(summary = "登录")
    @PostMapping("/signin")
    public Mono<ResponseEntity<?>> signin(@Valid @RequestBody LoginDto loginDto){
        return userService.findByUsernameOrEmail(loginDto.getUsernameOrEmail(), loginDto.getUsernameOrEmail())
                .map(user -> {
                    if (passwordEncoder.encode(loginDto.getPassword()).equals(user.getPassword())) {
                        String token = jwtUtil.generateToken(ModelMapper.mapUserToUserPrincipal(user));
                        return new ResponseEntity(token,HttpStatus.OK);
                    } else {
                        return new ResponseEntity("密码错误",HttpStatus.UNAUTHORIZED);
                    }
                });
    }


}
