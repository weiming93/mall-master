package com.emond.mall.common.constant;

/**
 * @description: 认证类型常量类
 * @author: Emond Chan
 */
public class AuthConstant {

    /**
     * 刷新模式
     */
    public static final String REFRESH_TOKEN = "refresh_token";
    /**
     * 授权码模式
     */
    public static final String AUTHORIZATION_CODE = "authorization_code";
    /**
     * 客户端模式
     */
    public static final String CLIENT_CREDENTIALS = "client_credentials";
    /**
     * 密码模式
     */
    public static final String PASSWORD = "password";
    /**
     * 简化模式
     */
    public static final String IMPLICIT = "implicit";

    /**
     * 验证码 key
     */
    public static final String VALIDATE_CODE_KEY = "key";
    /**
     * 验证码 code
     */
    public static final String VALIDATE_CODE_CODE = "code";
    /**
     * 认证类型参数 key
     */
    public static final String GRANT_TYPE = "grant_type";

    /**
     * 验证码 key前缀
     */
    public static final String CODE_PREFIX = "mall.captcha.";
}
