package com.cointeam.coin.controller;

import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.result.CollectCardsReturn;
import com.cointeam.coin.pojo.dto.result.CollectTextsReturn;
import com.cointeam.coin.pojo.dto.result.NoData;
import com.cointeam.coin.service.CollectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @author : ziv_l
 * create at:  2021/9/30  11:40
 * @description: 收藏相关接口
 */
@RestController
@Api(tags = "收藏相关接口：ziv")
@Slf4j
public class CollectController {

    @Autowired
    CollectService collectService;

    /**
     * 收藏卡片
     * @param cardId 卡片id
     * @return 操作成功
     */
    @GetMapping("/collect/card/add")
    @ApiOperation("收藏卡片")
    CommonResult<NoData> addCard(@RequestBody @NotNull Integer cardId){
        return collectService.addCard(cardId);
    }

    /**
     * 获取收藏卡片
     * @return 卡片列表
     */
    @GetMapping("/collect/cards")
    @ApiOperation("获取收藏卡片")
    CommonResult<CollectCardsReturn> getCards(){
        return collectService.getCards();
    }

    /**
     * 取消收藏卡片
     * @param cardId 卡片id
     * @return 操作结果
     */
    @GetMapping("/collect/card/delete")
    @ApiOperation("取消收藏卡片")
    CommonResult<NoData> deleteCard(@RequestBody @NotNull Integer cardId){
        return collectService.deleteCard(cardId);
    }

    /**
     * 收藏文章
     * @param textId 文章id
     * @return 操作结果
     */
    @GetMapping("/collect/text/add")
    @ApiOperation("收藏文章")
    CommonResult<NoData> addText(@RequestBody @NotNull Integer textId){
        return collectService.addText(textId);
    }

    /**
     * 获取收藏文章
     * @return 文章列表
     */
    @GetMapping("/collect/texts")
    @ApiOperation("获取收藏文章")
    CommonResult<CollectTextsReturn> getTexts(){
        return collectService.getTexts();
    }

    /**
     * 取消收藏文章
     * @param textId 文章id
     * @return 操作结果
     */
    @GetMapping("/collect/text/delete")
    @ApiOperation("取消收藏文章")
    CommonResult<NoData> deleteText(@RequestBody @NotNull Integer textId){
        return collectService.deleteText(textId);
    }
}