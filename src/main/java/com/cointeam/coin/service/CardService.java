package com.cointeam.coin.service;

import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.param.InsertBranchParam;
import com.cointeam.coin.pojo.dto.param.RoleParam;
import com.cointeam.coin.pojo.dto.result.CardResult;
import com.cointeam.coin.pojo.dto.result.NoData;

public interface CardService {

    CommonResult<CardResult> selectCard(RoleParam roleParam);

    CommonResult<CardResult> selectCardDetails(RoleParam roleParam);

    CommonResult<NoData> insertBranch(InsertBranchParam insertBranchParam);

}
