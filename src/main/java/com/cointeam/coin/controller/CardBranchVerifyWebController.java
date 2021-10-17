package com.cointeam.coin.controller;

import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.param.CardBranchVerifyWebParam;
import com.cointeam.coin.pojo.dto.result.CardBranchVerifyWebResult;
import com.cointeam.coin.service.CardBranchVerifyWebService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "cardWeb：李春强")
@CrossOrigin
@RestController
public class CardBranchVerifyWebController {

    @Autowired
    CardBranchVerifyWebService cardBranchVerifyWebService;

    @PostMapping("/card/branch/web")
    public CommonResult<CardBranchVerifyWebResult> cardBranchVerifyWeb(@RequestBody CardBranchVerifyWebParam cardBranchVerifyWebParam){

        return cardBranchVerifyWebService.cardBranchVerifyWeb(cardBranchVerifyWebParam);

    }

    @PostMapping("/card/web")
    public CommonResult<CardBranchVerifyWebResult> cardWeb(@RequestBody CardBranchVerifyWebParam cardBranchVerifyWebParam){

        return cardBranchVerifyWebService.cardWeb(cardBranchVerifyWebParam);

    }

}
