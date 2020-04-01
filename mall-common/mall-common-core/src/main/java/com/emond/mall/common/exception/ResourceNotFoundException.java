package com.emond.mall.common.exception;
/**
 * 资源不存在异常
 * @author Chen Weiming
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s不存在%s : '%s'", resourceName, fieldName, fieldValue));
    }
    public ResourceNotFoundException(String resourceName,  Object fieldValue) {
        super(String.format("%s不存在 : '%s'", resourceName, fieldValue));
    }

}
