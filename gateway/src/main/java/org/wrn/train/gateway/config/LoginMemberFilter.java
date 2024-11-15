package org.wrn.train.gateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import org.wrn.train.common.util.JwtUtil;
import reactor.core.publisher.Mono;

/**
 * @author: Admin
 * @Desc:
 * @create: 2024-11-15 15:26
 **/
public class LoginMemberFilter implements Ordered, GlobalFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginMemberFilter.class);


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();
        if (path.contains("/admin")
                || path.contains("/hello")
                || path.contains("/member/member/login")
                || path.contains("/member/member/sendCode")) {
            LOGGER.info("不需要登录验证:{}", path);
            return chain.filter(exchange);
        } else {
            LOGGER.info("需要登陆验证：{}", path);
        }
        String token = exchange.getRequest().getHeaders().getFirst("token");
        LOGGER.info("登录验证开始,token:{}", token);
        if (token == null || token.isEmpty()) {
            LOGGER.info("token为空，请求被拦截");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        boolean validate = JwtUtil.validate(token);
        if (validate) {
            LOGGER.info("token有效，放行请求");
            return chain.filter(exchange);
        } else {
            LOGGER.info("请求无效,请求被拦截");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
