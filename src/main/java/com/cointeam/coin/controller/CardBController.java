package com.cointeam.coin.controller;

import com.cointeam.coin.annotation.UserLoginToken;
import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.domain.Card;
import com.cointeam.coin.pojo.dto.param.CardParam;
import com.cointeam.coin.pojo.dto.result.CollectCardsReturn;
import com.cointeam.coin.service.CardBService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author : ziv_l
 * create at:  2021/10/26  00:18
 * @description: 卡片相关接口：B端操作
 */
@Slf4j
@Api(tags = "cardWeb(提交)：ziv")
@CrossOrigin
@RestController
@RequestMapping("/admin")
public class CardBController {

    @Autowired
    CardBService cardBService;

    /**
     * 管理员上传新的卡片
     * @return 返回操作结果
     */
    @PostMapping("/card/upload")
    @ApiOperation("管理员上传新的卡片")
    @UserLoginToken
    public CommonResult<Card> cardUpload(@RequestBody @Validated CardParam cardParam) {
        return cardBService.cardUpload(cardParam);
    }

    /**
     * 管理员获取card列表
     * @return card列表
     */
    @GetMapping("/card/list")
    @ApiOperation("管理员获取card列表")
    @UserLoginToken
    public CommonResult<CollectCardsReturn> getCardList() {
        return cardBService.getCardList();
    }
}