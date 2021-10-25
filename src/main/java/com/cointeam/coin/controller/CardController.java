package com.cointeam.coin.controller;

import com.cointeam.coin.annotation.UserLoginToken;
import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.param.InsertBranchParam;
import com.cointeam.coin.pojo.dto.param.InsertCardParam;
import com.cointeam.coin.pojo.dto.param.RoleParam;
import com.cointeam.coin.pojo.dto.result.CardDetailsResult;
import com.cointeam.coin.pojo.dto.result.CardResult;
import com.cointeam.coin.pojo.dto.result.NoData;
import com.cointeam.coin.service.CardService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Api(tags = "card：李春强")
@CrossOrigin
@RestController
@RequestMapping("/role")

public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/card/type")
    @UserLoginToken
    public CommonResult<CardResult> selectCard(@RequestBody RoleParam roleParam){
        return cardService.selectCard(roleParam);
    }


    @PostMapping("/card/details")
    @UserLoginToken
    public CommonResult<CardDetailsResult> selectCardDetails(@RequestBody RoleParam roleParam){
        return cardService.selectCardDetails(roleParam);
    }

    @UserLoginToken
    @PostMapping("/add/card/branch")
    public CommonResult<NoData> insertBranch(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse, @RequestBody InsertBranchParam insertBranchParam) {
        return cardService.insertBranch(httpServletRequest,httpServletResponse,insertBranchParam);
    }


    /**
     * 提交新卡片，重复提交即为更新(参数id不为空即为更新)
     * @author ziv
     * @param insertCardParam 参数
     * @return 操作结果
     */
    @UserLoginToken
    @PostMapping("/add/card")
    public CommonResult<InsertCardParam> insertCard(@RequestBody @Validated InsertCardParam insertCardParam) {
        return cardService.insertCard(insertCardParam);
    }
}
