package com.emond.mall.gateway.filter;

import com.emond.mall.common.constant.MallConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.util.Base64Utils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 添加header信息 MallConstant.GATEWAY_TOKEN_HEADER
 * @author: Chen Weiming
 */
@Slf4j
@Configuration
public class ServerProtectFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        byte[] token = Base64Utils.encode((MallConstant.GATEWAY_TOKEN_VALUE).getBytes());
        return chain.filter(
                exchange.mutate().request(
                        exchange.getRequest().mutate()
                                .header(MallConstant.GATEWAY_TOKEN_HEADER,new String(token))
                                .build())
                        .build());
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
