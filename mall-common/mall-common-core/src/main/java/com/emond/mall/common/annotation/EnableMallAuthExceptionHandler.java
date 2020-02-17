package com.emond.mall.common.annotation;

import com.emond.mall.common.config.AuthExceptionConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @description: 认证类型异常翻译
 * @author: Emond Chan
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AuthExceptionConfiguration.class)
public @interface EnableMallAuthExceptionHandler {
}
