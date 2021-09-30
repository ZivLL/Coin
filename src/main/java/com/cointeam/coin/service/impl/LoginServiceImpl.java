package com.cointeam.coin.service.impl;

import com.cointeam.coin.mapper.AdminMapper;
import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.domain.Admin;
import com.cointeam.coin.pojo.dto.param.LoginParam;
import com.cointeam.coin.pojo.dto.result.NoData;
import com.cointeam.coin.service.LoginService;
import com.hanzoy.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    JWTUtils jwtUtils;

    @Resource
    AdminMapper adminMapper;

    @Override
    public CommonResult<HashMap<String, Object>> login(LoginParam loginParam) {

        Admin admin = adminMapper.findAdmin(loginParam);
        if (admin == null) {
            return CommonResult.fail("1000","账号密码错误");
        }
        HashMap<String,Object> data = new HashMap<>();
        String token = jwtUtils.createToken(admin);
        data.put("token", token);

        //获取token里面的值
        Admin bean = jwtUtils.getBean(token,Admin.class);

        //认证token
        jwtUtils.checkToken(token);
        return CommonResult.success(data);
    }
}
