package com.blueocean.mall.common.core;


import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 获取当前登录的用户
 */
public class SecurityUtils {

    public static UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken() {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken;
        try {
            usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        } catch (Exception e) {
            throw new AccountExpiredException("登录状态过期");
        }
        return usernamePasswordAuthenticationToken;
    }


    /**
     * 获取系统用户id
     * @return 系统用户id
     */
    public static Long getUserId(){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = getUsernamePasswordAuthenticationToken();
        return (Long)usernamePasswordAuthenticationToken.getPrincipal();
    }
}
