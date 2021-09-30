package com.cointeam.coin.controller;

import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.domain.Text;
import com.cointeam.coin.pojo.dto.param.TextParam;
import com.cointeam.coin.service.TextUpLoadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : ziv_l
 * create at:  2021/9/28  20:47
 * @description: text上传相关的接口
 */
@RestController
@Api(tags = "text上传相关的接口:ziv")
@Slf4j
@RequestMapping("/text")
public class TextUpLoadController {

    @Autowired
    TextUpLoadService textUpLoadService;

    /**
     * 文章上传 (重复提交即为更新)
     * @param textParam 文章
     * @return 成功或者失败
     */
    @PostMapping("/upload")
    @ApiOperation("上传新的文章")
    public CommonResult<Text> textUpload(@RequestBody @Validated TextParam textParam){
        System.out.println("访问了 /text/upload 请求，参数：" + textParam.toString());
        return textUpLoadService.textUpload(textParam);
    }
}