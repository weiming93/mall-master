package com.emond.mall.auth.config;

import com.emond.mall.auth.properties.AuthProperties;
import com.emond.mall.common.constant.EndpointConstant;
import com.emond.mall.common.exception.handler.MallAccessDeniedHandler;
import com.emond.mall.common.exception.handler.MallAuthenticationEntryPoint;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @description: WebSecurity资源配置类
 * @author: Emond Chan
 */
@Configuration
@EnableResourceServer
public class AuthResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Autowired
    private MallAccessDeniedHandler accessDeniedHandler;

    @Autowired
    private MallAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private AuthProperties properties;
    @Override
    public void configure(HttpSecurity http) throws Exception {
        String[] anonUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(properties.getAnonUrl(), ",");

        http.csrf().disable()
                .requestMatchers().antMatchers(EndpointConstant.ALL)
                .and()
                .authorizeRequests()
                .antMatchers(anonUrls).permitAll()
                .antMatchers(EndpointConstant.ALL).authenticated()
                .and().httpBasic();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }
}
