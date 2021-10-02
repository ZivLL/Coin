package com.cointeam.coin.service.impl;

import com.cointeam.coin.mapper.UserMapper;
import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.domain.Device;
import com.cointeam.coin.pojo.dto.param.LoginParam;
import com.cointeam.coin.pojo.dto.result.LoginAuthResult;
import com.cointeam.coin.service.LoginService;
import com.hanzoy.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author 李春强
 * @Date 2021/10/1 20:14
 * @Param
 * @Return
 * @Description: 用户登录实现类
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    JWTUtils jwtUtils;

    @Autowired
    UserMapper userMapper;

    @Override
    public CommonResult<LoginAuthResult> login(@RequestBody LoginParam loginParam) {

        //创建返回体实体对象
        LoginAuthResult loginAuthResult = new LoginAuthResult();

        //通过name搜索数据库中是否有预设的user
        Device users = userMapper.selectUserByName(loginParam.getUsername(), loginParam.getPassword());

        if (users == null) {
            return CommonResult.fail("A0400a","账号密码错误");
        } else {
            String token = writeUserToToken(users);
            loginAuthResult.setToken(token);
            userMapper.updateToken(token,users.getUserName());
            return CommonResult.success(loginAuthResult);
        }

    }

    @Override
    public String writeUserToToken(Object user) {
        return jwtUtils.createTokenCustomFields(user, "userName", "password");
    }

}
