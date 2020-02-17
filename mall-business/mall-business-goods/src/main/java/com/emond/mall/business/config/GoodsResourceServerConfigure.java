package com.emond.mall.business.config;

import com.emond.mall.common.exception.handler.MallAccessDeniedHandler;
import com.emond.mall.common.exception.handler.MallAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;


/**
 * @description:    资源配置
 * @author: Emond Chan
 */
@Configuration
@EnableResourceServer
public class GoodsResourceServerConfigure extends ResourceServerConfigurerAdapter {
    @Autowired
    private MallAccessDeniedHandler accessDeniedHandler;

    @Autowired
    private MallAuthenticationEntryPoint authenticationEntryPoint;
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers("/**").authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }
}
