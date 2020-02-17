package com.emond.mall.common.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @description:
 * @author: Emond Chan
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:mall-common.properties"})
@ConfigurationProperties(prefix = "mall.common")
public class MallCommonProperties {
    private SwaggerProperties swagger = new SwaggerProperties();
    /**
     * 免认证 URI，多个值的话以逗号分隔
     */
    private String anonUrl;


}
