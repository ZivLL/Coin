package com.cointeam.coin.controller;

import com.cointeam.coin.annotation.UserLoginToken;
import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.param.InsertBranchParam;
import com.cointeam.coin.pojo.dto.param.RoleParam;
import com.cointeam.coin.pojo.dto.result.CardDetailsResult;
import com.cointeam.coin.pojo.dto.result.CardResult;
import com.cointeam.coin.pojo.dto.result.NoData;
import com.cointeam.coin.service.CardService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = "card：李春强")
@CrossOrigin
@RestController
@RequestMapping("/role")

public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/card/type")
    public CommonResult<CardResult> selectCard(@RequestBody RoleParam roleParam){
        return cardService.selectCard(roleParam);
    }

    @GetMapping("/card/details")
    public CommonResult<CardDetailsResult> selectCardDetails(@RequestParam RoleParam roleParam){
        return cardService.selectCardDetails(roleParam);
    }

    @PostMapping("/add/card/branch")
    public CommonResult<NoData> insertBranch(@RequestBody InsertBranchParam insertBranchParam) {
        return cardService.insertBranch(insertBranchParam);
    }
}
