package com.cointeam.coin.service;

import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.param.InsertBranchParam;
import com.cointeam.coin.pojo.dto.param.InsertCardParam;
import com.cointeam.coin.pojo.dto.param.RoleParam;
import com.cointeam.coin.pojo.dto.result.CardDetailsResult;
import com.cointeam.coin.pojo.dto.result.CardResult;
import com.cointeam.coin.pojo.dto.result.NoData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CardService {

    CommonResult<CardResult> selectCard(RoleParam roleParam);

    CommonResult<CardDetailsResult> selectCardDetails(RoleParam roleParam);

    CommonResult<NoData> insertBranch(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, InsertBranchParam insertBranchParam);

    CommonResult<InsertCardParam> insertCard(InsertCardParam insertCardParam);
}
