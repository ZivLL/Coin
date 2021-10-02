package com.cointeam.coin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @Author 李春强
 * @Date 2021/9/30 0:53
 * @Param
 * @Return
 * @Description: 自定义注解：需要登录才能进行操作
 */
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface UserLoginToken {
    boolean required() default true;
}
