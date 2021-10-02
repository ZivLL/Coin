package com.cointeam.coin.service.impl;

import com.cointeam.coin.mapper.UserMapper;
import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.param.RegisterParam;
import com.cointeam.coin.pojo.dto.result.NoData;
import com.cointeam.coin.service.RegisterService;
import com.hanzoy.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 李春强
 * @Date 2021/10/1 20:13
 * @Param
 * @Return
 * @Description: 用户注册实现类
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    UserMapper userMapper;

    @Override
    public CommonResult<NoData> Register(RegisterParam registerParam) {
        String nickName = registerParam.getNickName();
        String userId = registerParam.getUserId();
        String password = registerParam.getPassword();

        //md5加密
        String s = MD5Utils.MD5Upper(password);

        //获取当前时间戳
        long time = System.currentTimeMillis();

        userMapper.insertUser(userId, nickName, s, time);

        return CommonResult.success("注册成功");
    }
}
