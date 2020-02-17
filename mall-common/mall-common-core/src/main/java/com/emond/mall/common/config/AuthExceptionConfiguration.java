package com.emond.mall.common.config;

import com.emond.mall.common.exception.handler.MallAccessDeniedHandler;
import com.emond.mall.common.exception.handler.MallAuthenticationEntryPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @description:
 * @author: Emond Chan
 */
public class AuthExceptionConfiguration {
    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    public MallAccessDeniedHandler accessDeniedHandler() {
        return new MallAccessDeniedHandler();
    }

    @Bean
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public MallAuthenticationEntryPoint authenticationEntryPoint() {
        return new MallAuthenticationEntryPoint();
    }

    @Bean
    @ConditionalOnMissingBean(value = PasswordEncoder.class)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
