package com.emond.mall.auth.config;

import com.emond.mall.auth.properties.AuthProperties;
import com.emond.mall.auth.properties.ClientsProperties;
import com.emond.mall.auth.service.impl.CustomUserDetailsService;
import com.emond.mall.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
/**
 * @description: 认证配置类
 * @author: Emond Chan
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthProperties authProperties;
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        ClientsProperties[] clientsProperties = authProperties.getClients();
        for (ClientsProperties clientsProperty : clientsProperties) {
            if (StringUtils.isBlank(clientsProperty.getClient())){
                throw new Exception("client不能为空");
            }
            if (StringUtils.isBlank(clientsProperty.getSecret())) {
                throw new Exception("secret不能为空");
            }
            String[] grantTypes  = StringUtils.splitByWholeSeparator(clientsProperty.getGrantType(), ",");
            clients.inMemory()
                    .withClient(clientsProperty.getClient())
                    .secret(passwordEncoder.encode(clientsProperty.getSecret()))
                    .authorizedGrantTypes(grantTypes)
                    .scopes(clientsProperty.getScope());
        }

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore())
                .userDetailsService(customUserDetailsService)
                .authenticationManager(authenticationManager)
                .tokenServices(defaultTokenServices());
    }

    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Primary
    @Bean
    public DefaultTokenServices defaultTokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore());
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setAccessTokenValiditySeconds(authProperties.getAccessTokenValiditySeconds());
        tokenServices.setRefreshTokenValiditySeconds(authProperties.getRefreshTokenValiditySeconds());
        return tokenServices;
    }
}
