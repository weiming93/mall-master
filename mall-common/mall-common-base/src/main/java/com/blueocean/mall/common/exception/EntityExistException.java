package com.blueocean.mall.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityExistException extends RuntimeException {

    public EntityExistException(String resourceName,  Object fieldValue) {
        super(String.format("%s 已存在 : '%s'", resourceName, fieldValue));
    }
}
