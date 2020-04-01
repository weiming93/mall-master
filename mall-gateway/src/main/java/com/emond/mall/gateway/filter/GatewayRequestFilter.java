package com.emond.mall.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 请求信息记录
 * @author: Chen Weiming
 */
@Slf4j
@Component
public class GatewayRequestFilter implements GlobalFilter, Ordered {
    private static final String REQUEST_TIME_BEGIN = "requestTimeBegin";
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Route route = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
        exchange.getAttributes().put(REQUEST_TIME_BEGIN, System.currentTimeMillis());
        return chain.filter(exchange).then(
                Mono.fromRunnable(() ->{
                    Long startTime = exchange.getAttribute(REQUEST_TIME_BEGIN);
                    if (startTime != null){
                        log.info("请求服务：{}，请求路径：{}，请求数据：{}，消耗时间：{}ms"
                                ,route.getUri().getHost()
                                ,exchange.getRequest().getPath()
                                ,exchange.getRequest().getQueryParams()
                                ,(System.currentTimeMillis() - startTime));
                    }
                })
        );
    }

    @Override
    public int getOrder() {
        return 0;
    }


}
