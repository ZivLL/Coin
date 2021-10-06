package com.cointeam.coin.service.impl;

import com.cointeam.coin.mapper.CardWebMapper;
import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.param.CardBranchVerifyWebParam;
import com.cointeam.coin.pojo.dto.result.NoData;
import com.cointeam.coin.service.UpdateStatusForCardWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateStatusForCardWebServiceImpl implements UpdateStatusForCardWebService {

    @Autowired
    CardWebMapper cardWebMapper;

    @Override
    public CommonResult<NoData> UpdateStatusForCardWeb(CardBranchVerifyWebParam cardBranchVerifyWebParam) {

        cardWebMapper.updateWebStatus(cardBranchVerifyWebParam);

        return CommonResult.success("修改状态成功");
    }
}
