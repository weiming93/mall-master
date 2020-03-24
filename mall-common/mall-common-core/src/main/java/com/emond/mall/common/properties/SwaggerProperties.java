package com.emond.mall.common.properties;

import lombok.Data;

/**
 * @description:
 * @author: Chen Weiming
 */
@Data
public class SwaggerProperties {
    private String basePackage;
    private String title;
    private String description;
    private String version;
    private String author;
    private String url;
    private String email;
    private String license;
    private String licenseUrl;

    private String grantUrl;
    private String name;
    private String scope;
}
