package com.cointeam.coin.controller;


import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.result.AuditBranchReturn;
import com.cointeam.coin.pojo.dto.result.AuditCardReturn;
import com.cointeam.coin.service.AuditService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : ziv_l
 * create at:  2021/10/4  11:19
 * @description: 我的分享
 */

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/audit")
@Api(tags = "我的分享：ziv")
public class AuditController {

    @Autowired
    AuditService auditService;

    /**
     * 获取我的分享：卡片
     * @return 包装类
     */
    @GetMapping("/cards")
    @ApiOperation("获取我的分享：卡片")
    public CommonResult<AuditCardReturn> getAuditingCards(){
        return auditService.getAuditingCards();
    }

    /**
     * 获取我的分享：分支
     * @return 包装类
     */
    @GetMapping("/branches")
    @ApiOperation("获取我的分享：分支")
    public CommonResult<AuditBranchReturn> getAuditingBranch(){
        return auditService.getAuditingBranch();
    }
}