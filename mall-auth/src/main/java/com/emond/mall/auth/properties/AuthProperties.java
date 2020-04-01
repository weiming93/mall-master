package com.emond.mall.auth.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * Auth相关的配置类
 * @author: Chen Weiming
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:mall-auth.properties"})
@ConfigurationProperties(prefix = "mall.auth")
public class AuthProperties {

    private ClientsProperties[] clients = {};
    private int accessTokenValiditySeconds = 60 * 60 * 24;
    private int refreshTokenValiditySeconds = 60 * 60 * 24 * 7;

    /**
     * 免认证访问路径
     */
    private String anonUrl;
    /**
     * 验证码配置
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();
}
