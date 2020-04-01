package com.emond.mall.common.config;

import com.emond.mall.common.exception.handler.MallAccessDeniedHandler;
import com.emond.mall.common.exception.handler.MallAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * @author: Chen Weiming
 */
public class AuthExceptionConfiguration {
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new MallAccessDeniedHandler();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new MallAuthenticationEntryPoint();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
