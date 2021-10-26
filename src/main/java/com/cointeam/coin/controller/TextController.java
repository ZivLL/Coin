package com.cointeam.coin.controller;

import com.cointeam.coin.annotation.UserLoginToken;
import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.domain.Text;
import com.cointeam.coin.pojo.dto.param.TextParam;
import com.cointeam.coin.pojo.dto.result.TextListReturn;
import com.cointeam.coin.service.TextService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @author : ziv_l
 * create at:  2021/9/28  20:47
 * @description: text上传相关的接口
 */
@RestController
@Api(tags = "text相关的接口:ziv")
@Slf4j
public class TextController {

    @Autowired
    TextService textService;

    /**
     * 文章上传 (重复提交即为更新)
     * @param textParam 文章
     * @return 成功或者失败
     */
    @PostMapping("/text/upload")
    @ApiOperation("上传新的文章")
    @UserLoginToken
    public CommonResult<Text> textUpload(@RequestBody @Validated TextParam textParam){
        return textService.textUpload(textParam);
    }

    /**
     * 获取文章
     * @return 今日文章
     */
    @GetMapping("/role/text")
    @ApiOperation("获取今日文章")
    @UserLoginToken
    public CommonResult<Text> getText(@RequestParam @NotNull Integer type) {
        System.out.println("访问了 /text/today 请求");
        return textService.getText(type);
    }

    /**
     * 获取文章列表
     * @param type 板块参数
     * @return 文章列表
     */
    @GetMapping("/text/list")
    @ApiOperation("获取所有文章")
    @UserLoginToken
    public CommonResult<TextListReturn> getTextList(@RequestParam @NotNull Integer type) {
        System.out.println("访问了 /text/today 请求");
        return textService.getTextList(type);
    }
}