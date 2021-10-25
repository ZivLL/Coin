package com.cointeam.coin.service.impl;

import com.cointeam.coin.mapper.CardWebMapper;
import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.domain.AuditBranch;
import com.cointeam.coin.pojo.domain.AuditCard;
import com.cointeam.coin.pojo.dto.param.CardBranchVerifyWebParam;
import com.cointeam.coin.pojo.dto.result.NoData;
import com.cointeam.coin.service.UpdateStatusForCardWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UpdateStatusForCardWebServiceImpl implements UpdateStatusForCardWebService {

    @Autowired
    CardWebMapper cardWebMapper;

    @Override
    public CommonResult<NoData> UpdateStatusForCardWeb(ArrayList<CardBranchVerifyWebParam> cardBranchVerifyWebParam) {


        for (CardBranchVerifyWebParam branchVerifyWebParam : cardBranchVerifyWebParam) {
            cardWebMapper.updateWebStatus(branchVerifyWebParam);
            AuditBranch auditBranch = cardWebMapper.selectBranchById(branchVerifyWebParam);
            cardWebMapper.insertCardBranch(auditBranch);
        }



        return CommonResult.success("修改状态成功");
    }

    @Override
    public CommonResult<NoData> updateCardWebStatus(ArrayList<CardBranchVerifyWebParam> cardBranchVerifyWebParam) {

        for (CardBranchVerifyWebParam branchVerifyWebParam : cardBranchVerifyWebParam) {
            cardWebMapper.updateCardWebStatus(branchVerifyWebParam);
            AuditCard auditCard = cardWebMapper.selectAuditCardId(branchVerifyWebParam);
            cardWebMapper.insertCard(auditCard);
        }


        return CommonResult.success("修改状态成功");
    }
}
