package com.blueocean.mall.common.core;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.*;

/**
 * 在controller类的方法参数中使用
 * @CurrentUser UserPrincipal currentUser
 * 会自动注入
 */
@Target({ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AuthenticationPrincipal
    public @interface CurrentUser {

}
