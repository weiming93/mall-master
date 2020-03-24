package com.emond.mall.common.annotation;

import com.emond.mall.common.config.ServerProtectConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @description: 开启微服务防护，避免客户端绕过网关直接请求微服务
 * @author: Chen Weiming
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ServerProtectConfiguration.class)
public @interface EnableMallServerProtect {
}
