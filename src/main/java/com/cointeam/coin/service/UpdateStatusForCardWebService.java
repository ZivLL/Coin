package com.cointeam.coin.service;


import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.param.CardBranchVerifyWebParam;
import com.cointeam.coin.pojo.dto.result.NoData;

public interface UpdateStatusForCardWebService {

    CommonResult<NoData> UpdateStatusForCardWeb(CardBranchVerifyWebParam cardBranchVerifyWebParam);

    CommonResult<NoData> updateCardWebStatus(CardBranchVerifyWebParam cardBranchVerifyWebParam);

}
