package com.cointeam.coin.service;

import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.param.LoginParam;
import com.cointeam.coin.pojo.dto.result.LoginAuthResult;
import com.cointeam.coin.pojo.dto.result.NoData;

import java.util.HashMap;

public interface LoginService {

    CommonResult<LoginAuthResult> login(LoginParam loginParam);

    /**
     * 业务封装方法，将User内容写入token
     * @param user 需要解析的实体类
     * @return token
     */
    String writeUserToToken(Object user);
}
