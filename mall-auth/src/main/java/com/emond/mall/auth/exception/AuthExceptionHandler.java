package com.emond.mall.auth.exception;

import com.emond.mall.common.exception.handler.BaseExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: Chen Weiming
 */
@RestControllerAdvice
public class AuthExceptionHandler extends BaseExceptionHandler {

}
