package com.cointeam.coin.service.impl;

import com.cointeam.coin.mapper.TextMapper;
import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.domain.Text;
import com.cointeam.coin.pojo.dto.param.TextParam;
import com.cointeam.coin.pojo.dto.result.TextListReturn;
import com.cointeam.coin.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author : ziv_l
 * create at:  2021/9/28  20:51
 * @description: text上传接口实现类
 */
@Service
public class TextServiceImpl implements TextService {

    @Autowired
    TextMapper textMapper;

    @Override
    public CommonResult<Text> textUpload(TextParam textParam) {

        // check type number
        if (textParam.getType() >= 5 || textParam.getType() <= 0) return CommonResult.fail("type 参数错误");

        // make example
        Text text = new Text();
        text.setId(textParam.getId());
        text.setTime(textParam.getTime());
        text.setAuthor(textParam.getAuthor());
        text.setContent(textParam.getContent());
        text.setTitle(textParam.getTitle());
        text.setPicUrl(textParam.getPicUrl());
        text.setType(textParam.getType());
        text.setPublicTime(textParam.getPublicTime());
        // 区分 id 以判断是否为更新或者插入操作
        // insert when id is null
        if (textParam.getId() == null) {
            textMapper.insert(text);
            return CommonResult.success("文章成功插入数据库", text);
        }
        if (textParam.getId() <= 0) return CommonResult.fail("id 参数错误");
        if (textMapper.selectByPrimaryKey(textParam.getId()) == null) return CommonResult.fail("该文章不存在，更新失败");
        textMapper.updateByPrimaryKey(text);
        return CommonResult.success("文章更新成功", text);
    }

    @Override
    public CommonResult<Text> getText(Integer type) {
        // check type
        if (type <= 0 || type > 4) return CommonResult.fail("参数异常");

        List<Text> texts = textMapper.selectAllByType(type);
        if (texts.isEmpty()) return CommonResult.fail("暂无今日文章");
        Long aDay = 24 * 60 * 60 * 1000L;
        for (Text text : texts) {
            Date date = new Date();
            long textEndTime = text.getPublicTime() + aDay - 1;
            if (date.getTime() >= text.getPublicTime() && date.getTime() <= textEndTime) {
                return CommonResult.success(text);
            }
        }
        return CommonResult.fail("数据库资源错误");
    }

    @Override
    public CommonResult<TextListReturn> getTextList(Integer type) {
        // check type
        if (type <= 0 || type > 4) return CommonResult.fail("参数异常");

        List<Text> texts = textMapper.selectAllByType(type);
        if (texts.isEmpty()) return CommonResult.fail("数据库暂无文章");

        // 封装返回类
        TextListReturn textListReturn = new TextListReturn();
        textListReturn.setTexts(texts);
        textListReturn.setTotal(texts.size());

        return CommonResult.success(textListReturn);
    }
}