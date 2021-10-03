package com.cointeam.coin.utils;


import com.cointeam.coin.utils.redis.RedisUtil;
import com.hanzoy.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@ConfigurationProperties(prefix = "token")
public class JWTTimeUtil {

    @Autowired
    JWTUtils jwtUtils;

    @Autowired
    RedisUtil redisUtil;

    public boolean refreshToken(String token, String userName, String passWord) {
        String tokenKey = "coinToken" + token ;
        String cacheToken = String.valueOf(redisUtil.get(tokenKey));
        if (cacheToken.isEmpty()) {
            // 校验token有效性，注意需要校验的是缓存中的token
            if (!jwtUtils.checkToken(cacheToken)) {
                String newToken = jwtUtils.createToken(userName, passWord);
                // 设置超时时间tokenKey
                redisUtil.set(tokenKey, newToken, (long) (60 * 60 * 24 * 7), TimeUnit.SECONDS);
            }
            return true;
        }
        return false;
    }

}
