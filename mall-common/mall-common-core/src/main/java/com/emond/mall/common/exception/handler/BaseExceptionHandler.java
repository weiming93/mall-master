package com.emond.mall.common.exception.handler;

import com.emond.mall.common.exception.BadRequestException;
import com.emond.mall.common.exception.EntityExistException;
import com.emond.mall.common.exception.ResourceNotFoundException;
import com.emond.mall.common.utils.ThrowableUtils;
import io.netty.util.internal.ThrowableUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;

@Slf4j
public class BaseExceptionHandler {
    /**
     * 处理所有不可知的异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exceptionRest(Throwable e) {
        // 打印堆栈信息
        log.error(ThrowableUtils.stackTraceToString(e));
        return "服务器异常";
    }


    /**
     * 处理 接口无权访问异常AccessDeniedException
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String exceptionRest(AccessDeniedException e) {
        // 打印堆栈信息
        log.error(ThrowableUtils.stackTraceToString(e));
        return "没有权限访问该资源";
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String exceptionRest(AuthenticationException e) {
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
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        // 打印堆栈信息
        log.error(ThrowableUtil.stackTraceToString(e));
        String[] str = Objects.requireNonNull(e.getBindingResult().getAllErrors().get(0).getCodes())[1].split("\\.");
        String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        String msg = "不能为空";
        if(msg.equals(message)){
            message = str[1] + ":" + message;
        }
        return message;
    }
}
