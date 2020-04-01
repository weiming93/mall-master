package com.emond.mall.gateway.fallback;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author: Chen Weiming
 */
@RestController
public class AuthFallback {
    @RequestMapping("fallback/{name}")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mono<String> systemFallback(@PathVariable String name) {
        return Mono.just(String.format("访问%s超时或者服务不可用", name));
    }
}
