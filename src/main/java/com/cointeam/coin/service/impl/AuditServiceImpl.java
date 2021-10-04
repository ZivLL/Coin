package com.cointeam.coin.service.impl;

import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.result.AuditBranchReturn;
import com.cointeam.coin.pojo.dto.result.AuditCardReturn;
import com.cointeam.coin.service.AuditService;
import org.springframework.stereotype.Service;

/**
 * @author : ziv_l
 * create at:  2021/10/4  11:17
 * @description: 我的分享功能实现类
 */
@Service
public class AuditServiceImpl implements AuditService {

    @Override
    public CommonResult<AuditCardReturn> getAuditingCards() {
        return null;
    }

    @Override
    public CommonResult<AuditBranchReturn> getAuditingBranch() {
        return null;
    }
}