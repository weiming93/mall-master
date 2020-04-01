package com.emond.mall.common.exception;

/**
 * 实体已经存在异常
 * @author Chen Weiming
 */
public class EntityExistException extends RuntimeException {

    public EntityExistException(String resourceName,  Object fieldValue) {
        super(String.format("%s已存在 : '%s'", resourceName, fieldValue));
    }

    public EntityExistException(String message) {
        super(message);
    }
}
