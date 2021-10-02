package com.cointeam.coin.config;

import com.cointeam.coin.Interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 李春强
 * @Date 2021/10/1 20:06
 * @Param
 * @Return
 * @Description: 注册拦截器
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**");
    }

    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
}