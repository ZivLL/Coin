package com.cointeam.coin.service;

import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.result.AuditBranchReturn;
import com.cointeam.coin.pojo.dto.result.AuditCardReturn;

public interface AuditService {

    CommonResult<AuditCardReturn> getAuditingCards();

    CommonResult<AuditBranchReturn> getAuditingBranch();
}
