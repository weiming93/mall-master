package com.blueocean.mall.common.exception.handler;

import com.blueocean.mall.common.exception.BadRequestException;
import com.blueocean.mall.common.exception.EntityExistException;
import com.blueocean.mall.common.exception.ResourceNotFoundException;
import io.netty.util.internal.ThrowableUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

import java.util.Objects;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {
    /**
     * 处理所有不可知的异常
     */
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mono<String> exceptionRest(Throwable e){
        // 打印堆栈信息
        log.error(ThrowableUtil.stackTraceToString(e));
        return Mono.just("服务器异常");
    }

    /**
     * 处理 接口无权访问异常AccessDeniedException
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Mono<String> exceptionRest(AccessDeniedException e){
        // 打印堆栈信息
        log.error(ThrowableUtil.stackTraceToString(e));
        return Mono.just(e.getMessage());
    }

    /**
     * 处理错误的请求
     */
    @ExceptionHandler(value = BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Mono<String> exceptionRest(BadRequestException e) {
        // 打印堆栈信息
        log.error(ThrowableUtil.stackTraceToString(e));
        return Mono.just(e.getMessage());
    }

    /**
     * 资源不存在
     */
    @ExceptionHandler(value = ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Mono<String> exceptionRest(ResourceNotFoundException e) {
        // 打印堆栈信息
        log.error(ThrowableUtil.stackTraceToString(e));
        return Mono.just(e.getMessage());
    }

    /**
     * 对象已存在
     */
    @ExceptionHandler(value = EntityExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Mono<String> exceptionRest(EntityExistException e) {
        // 打印堆栈信息
        log.error(ThrowableUtil.stackTraceToString(e));
        return Mono.just(e.getMessage());
    }

    /**
     * 处理所有接口数据验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Mono<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        // 打印堆栈信息
        log.error(ThrowableUtil.stackTraceToString(e));
        String[] str = Objects.requireNonNull(e.getBindingResult().getAllErrors().get(0).getCodes())[1].split("\\.");
        String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        if("不能为空".equals(message)){
            message = str[1] + ":" + message;
        }
        return Mono.just(message);
    }
}
