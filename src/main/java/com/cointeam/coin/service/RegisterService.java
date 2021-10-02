package com.cointeam.coin.service;

import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.param.RegisterParam;
import com.cointeam.coin.pojo.dto.result.NoData;
import org.springframework.web.bind.annotation.RequestParam;

public interface RegisterService {

    CommonResult<NoData> Register(RegisterParam registerParam);

}
