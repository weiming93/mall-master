package com.emond.mall.common.exception.handler;

import com.emond.mall.common.ThrowableUtils;
import com.emond.mall.common.exception.BadRequestException;
import com.emond.mall.common.exception.EntityExistException;
import com.emond.mall.common.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.Objects;
import java.util.Set;

@Slf4j
public class BaseExceptionHandler {
    /**
     * 处理所有不可知的异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exceptionRest(Exception e){
        // 打印堆栈信息
        log.error(ThrowableUtils.stackTraceToString(e));
        return "服务器异常";
    }

    /**
     * 处理 接口无权访问异常AccessDeniedException
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String exceptionRest(AccessDeniedException e){
        // 打印堆栈信息
        log.error(ThrowableUtils.stackTraceToString(e));
        return "没有权限访问该资源";
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String exceptionRest(AuthenticationException e){
        // 打印堆栈信息
        log.error(ThrowableUtils.stackTraceToString(e));
        return e.getMessage();
    }
    /**
     * 处理错误的请求
     */
    @ExceptionHandler(value = BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String exceptionRest(BadRequestException e) {
        // 打印堆栈信息
        log.error(ThrowableUtils.stackTraceToString(e));
        return e.getMessage();
    }

    /**
     * 资源不存在
     */
    @ExceptionHandler(value = ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String exceptionRest(ResourceNotFoundException e) {
        // 打印堆栈信息
        log.error(ThrowableUtils.stackTraceToString(e));
        return e.getMessage();
    }

    /**
     * 对象已存在
     */
    @ExceptionHandler(value = EntityExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String exceptionRest(EntityExistException e) {
        // 打印堆栈信息
        log.error(ThrowableUtils.stackTraceToString(e));
        return e.getMessage();
    }


    /**
     * 处理所有接口数据验证异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public String handleMethodArgumentNotValidException(ConstraintViolationException e){
        // 打印堆栈信息
        log.error(ThrowableUtils.stackTraceToString(e));
        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            Path path = violation.getPropertyPath();
            message.append(path).append(violation.getMessage()).append(",");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return message.toString();
    }
}
