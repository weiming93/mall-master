package com.blueocean.mall.common.exception;

public class EntityExistException extends RuntimeException {

    public EntityExistException(String resourceName,  Object fieldValue) {
        super(String.format("%s已存在 : '%s'", resourceName, fieldValue));
    }
}
