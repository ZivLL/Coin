package com.cointeam.coin.service;

import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.param.LoginParam;
import com.cointeam.coin.pojo.dto.result.NoData;

import java.util.HashMap;

public interface LoginService {

    CommonResult<HashMap<String, Object>> login(LoginParam loginParam);

}
