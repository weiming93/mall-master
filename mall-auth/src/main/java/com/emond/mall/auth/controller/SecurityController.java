package com.emond.mall.auth.controller;

import com.emond.mall.auth.exception.ValidateCodeException;
import com.emond.mall.auth.service.ValidateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * @author: Chen Weiming
 */
@RestController
public class SecurityController {
    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @Autowired
    private ValidateCodeService validateCodeService;

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
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

    @GetMapping("captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException, ValidateCodeException {
        validateCodeService.create(request, response);
    }
}
