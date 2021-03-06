package com.cointeam.coin.service;


import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.param.CardBranchVerifyWebParam;
import com.cointeam.coin.pojo.dto.result.NoData;

import java.util.ArrayList;

public interface UpdateStatusForCardWebService {

    CommonResult<NoData> UpdateStatusForCardWeb(ArrayList<CardBranchVerifyWebParam> cardBranchVerifyWebParam);

    CommonResult<NoData> updateCardWebStatus(ArrayList<CardBranchVerifyWebParam> cardBranchVerifyWebParam);

}
