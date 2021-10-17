package com.cointeam.coin.service.impl;

import com.cointeam.coin.mapper.CardPartMapper;
import com.cointeam.coin.mapper.CardWebMapper;
import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.bo.CardBranchVerifyWebBo;
import com.cointeam.coin.pojo.dto.param.CardBranchVerifyWebParam;
import com.cointeam.coin.pojo.dto.result.CardBranchVerifyWebResult;
import com.cointeam.coin.pojo.po.CardBranchVerifyWebPo;
import com.cointeam.coin.pojo.po.CardWebPo;
import com.cointeam.coin.service.CardBranchVerifyWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@Service
public class CardBranchVerifyWebServiceImpl implements CardBranchVerifyWebService {

    @Autowired
    CardWebMapper cardWebMapper;

    @Override
    public CommonResult<CardBranchVerifyWebResult> cardBranchVerifyWeb(CardBranchVerifyWebParam cardBranchVerifyWebParam) {

        CardBranchVerifyWebResult cardBranchVerifyWebResult = new CardBranchVerifyWebResult();
        ArrayList<CardBranchVerifyWebBo> cardBranchVerifyWebBos = new ArrayList<>();

        ArrayList<CardBranchVerifyWebPo> cardBranchVerifyWebPos = cardWebMapper.selectCardBranchVerifyWeb(cardBranchVerifyWebParam);

        for (CardBranchVerifyWebPo cardBranchVerifyWebPo : cardBranchVerifyWebPos) {
            CardBranchVerifyWebBo cardBranchVerifyWebBo = new CardBranchVerifyWebBo();

            Integer id = cardBranchVerifyWebPo.getId();

            Long time = cardBranchVerifyWebPo.getTime();
            String t = transformTime(time);

            Integer deviceId = cardBranchVerifyWebPo.getDeviceId();
            String nickName = cardWebMapper.selectNickNameByDeviceId(deviceId);

            Integer cardId = cardBranchVerifyWebPo.getCardId();
            String title = cardWebMapper.selectTitleByCardId(cardId);

            String content = cardBranchVerifyWebPo.getContent();
            Integer status = cardBranchVerifyWebPo.getStatus();

            cardBranchVerifyWebBo.setId(id);
            cardBranchVerifyWebBo.setTime(t);
            cardBranchVerifyWebBo.setNickName(nickName);
            cardBranchVerifyWebBo.setTitle(title);
            cardBranchVerifyWebBo.setContent(content);
            cardBranchVerifyWebBo.setStatus(status);

            cardBranchVerifyWebBos.add(cardBranchVerifyWebBo);
        }

        cardBranchVerifyWebResult.setCardBranchVerifyWebBos(cardBranchVerifyWebBos);

        return CommonResult.success(cardBranchVerifyWebResult);
    }

    @Override
    public CommonResult<CardBranchVerifyWebResult> cardWeb(CardBranchVerifyWebParam cardBranchVerifyWebParam) {

        CardBranchVerifyWebResult cardBranchVerifyWebResult = new CardBranchVerifyWebResult();
        ArrayList<CardBranchVerifyWebBo> cardBranchVerifyWebBos = new ArrayList<>();

        ArrayList<CardWebPo> cardWebPos = cardWebMapper.selectCardWeb(cardBranchVerifyWebParam);

        for (CardWebPo cardWebPo : cardWebPos) {
            CardBranchVerifyWebBo cardBranchVerifyWebBo = new CardBranchVerifyWebBo();

            Integer id = cardWebPo.getId();

            Long time = cardWebPo.getTime();
            String t = transformTime(time);

            Integer deviceId = cardWebPo.getDeviceId();
            String nickName = cardWebMapper.selectNickNameByDeviceId(deviceId);

            String title = cardWebPo.getTitle();
            String content = cardWebPo.getContent();
            Integer status = cardWebPo.getStatus();

            cardBranchVerifyWebBo.setId(id);
            cardBranchVerifyWebBo.setTime(t);
            cardBranchVerifyWebBo.setNickName(nickName);
            cardBranchVerifyWebBo.setTitle(title);
            cardBranchVerifyWebBo.setContent(content);
            cardBranchVerifyWebBo.setStatus(status);

            cardBranchVerifyWebBos.add(cardBranchVerifyWebBo);
        }

        cardBranchVerifyWebResult.setCardBranchVerifyWebBos(cardBranchVerifyWebBos);


        return CommonResult.success();
    }

    /**
     * 处理时间 毫秒转为字符串 最多精确到分
     * @param time
     * @return
     */
    public String transformTime(Long time){

        //获取当前日期时间
        LocalDateTime now = LocalDateTime.now();

        Date date = new Date(time);

        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");// 格式化时间
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");// 格式化时间
        SimpleDateFormat sdf3 = new SimpleDateFormat("MM.dd");// 格式化时间

        String format = sdf.format(date);
        String format2 = sdf2.format(date);
        String format3 = sdf3.format(date);

        //时间切片
        String[] split = format.split("-", 3);

        //返回时间
        if (new Integer(split[0]) < year){
            return format;
        } else if (new Integer(split[2]) < day - 1){
            return format3;
        } else if (new Integer(split[2]) == day -1){
            return "昨天";
        } else {
            return format2;
        }
    }



}











