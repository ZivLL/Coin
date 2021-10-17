package com.cointeam.coin.service;

import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.param.CardBranchVerifyWebParam;
import com.cointeam.coin.pojo.dto.result.CardBranchVerifyWebResult;

public interface CardBranchVerifyWebService {

    CommonResult<CardBranchVerifyWebResult> cardBranchVerifyWeb(CardBranchVerifyWebParam cardBranchVerifyWebParam);

    CommonResult<CardBranchVerifyWebResult> cardWeb(CardBranchVerifyWebParam cardBranchVerifyWebParam);

}
