package com.emond.mall.common.exception;
/**
 * 非法请求异常
 * @author Chen Weiming
 */
public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
