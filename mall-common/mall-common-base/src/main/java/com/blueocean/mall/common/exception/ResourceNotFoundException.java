package com.blueocean.mall.common.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s不存在%s : '%s'", resourceName, fieldName, fieldValue));
    }

}
