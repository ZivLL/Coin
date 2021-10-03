package com.cointeam.coin.mapper;

import com.cointeam.coin.pojo.domain.Device;
import com.cointeam.coin.pojo.dto.param.LoginParam;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    /**
     * 通过loginParam（userName和password的包装）查询用户
     */
    Device findAdmin(@Param("loginParam") LoginParam loginParam);

    /**
     * 通过userName查询用户
     */
    Device findAdminByUserName(@Param("userName") String userName);

    /**
     * 通过userName和password查询用户
     */
    Device selectUserByName(@Param("userId") String userId,
                            @Param("password") String password);

    /**
     * 向数据库中插入用户登录信息（注册接口），默认从1开始
     */
    void insertUser(@Param("nickName") String nickName, @Param("userName") String userName, @Param("password") String password, @Param("time") Long time);

    /**
     * 通过userId来变更token
     */
    void updateToken(@Param("token") String token, @Param("userId") String userId);
}
