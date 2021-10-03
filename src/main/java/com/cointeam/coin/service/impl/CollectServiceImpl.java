package com.cointeam.coin.service.impl;

import com.cointeam.coin.mapper.DeviceMapper;
import com.cointeam.coin.mapper.MyCollectCardMapper;
import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.result.CollectCardsReturn;
import com.cointeam.coin.pojo.dto.result.CollectTextsReturn;
import com.cointeam.coin.pojo.dto.result.NoData;
import com.cointeam.coin.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : ziv_l
 * create at:  2021/9/30  11:41
 * @description: 收藏实现类
 */
@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    DeviceMapper deviceMapper;
    @Autowired
    MyCollectCardMapper myCollectCardMapper;
//    @Autowired
//    CardMapper cardMapper;

    @Autowired
    HttpServletRequest httpServletRequest;

    @Override
    public CommonResult<NoData> addCard(Integer cardId) {
//        // get device id
//        String token = httpServletRequest.getHeader("token");
//        Device device = deviceMapper.selectByToken(token);
//        // check device
//        if (device == null) return CommonResult.fail("该账号不存在");
//        // check card id
//        Card card = cardMapper.selectByPrimaryKey(cardId);
//        if (card == null) return CommonResult.fail("该卡片不存在");
//        // add card to personal collect
//        // set example
//        MyCollectCard myCollectCard = new MyCollectCard();
//        myCollectCard.setCardId(cardId);
//        myCollectCard.setDeviceId(device.getId());
//        myCollectCard.setTime(System.currentTimeMillis());
//
//        // insert
//        myCollectCardMapper.insert(myCollectCard);
//
//        // return
//        return CommonResult.success();
        return null;
    }

    @Override
    public CommonResult<CollectCardsReturn> getCards() {
        return null;
    }

    @Override
    public CommonResult<NoData> deleteCard(Integer cardId) {
        return null;
    }

    @Override
    public CommonResult<NoData> addText(Integer textId) {
        return null;
    }

    @Override
    public CommonResult<CollectTextsReturn> getTexts() {
        return null;
    }

    @Override
    public CommonResult<NoData> deleteText(Integer textId) {
        return null;
    }
}