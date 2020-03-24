package com.emond.mall.auth.properties;

import lombok.Data;

/**
 * @description: Client配置类
 * @author: Chen Weiming
 */
@Data
public class ClientsProperties {
    private String client;
    private String secret;
    private String grantType = "password,authorization_code,refresh_token";
    private String scope = "all";
}
