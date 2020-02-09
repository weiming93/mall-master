package com.emond.mall.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: Emond Chan
 */
@RestController
public class SecurityController {
    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @GetMapping("test")
    public String testOauth() {
        return "oauth";
    }

    @DeleteMapping("signout")
    public String signout(HttpServletRequest request) throws Exception {
        String authorization = request.getHeader("Authorization");
        String token = authorization.replace("bearer ", "");
        if (!consumerTokenServices.revokeToken(token)) {
            throw new Exception("退出登录失败");
        }
        return "退出登录成功";
    }
}
