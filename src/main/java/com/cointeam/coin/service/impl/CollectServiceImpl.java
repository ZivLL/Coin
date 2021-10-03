package com.cointeam.coin.service.impl;

import com.cointeam.coin.mapper.*;
import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.domain.*;
import com.cointeam.coin.pojo.dto.result.CollectCardsReturn;
import com.cointeam.coin.pojo.dto.result.CollectTextsReturn;
import com.cointeam.coin.pojo.dto.result.NoData;
import com.cointeam.coin.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    @Autowired
    MyCollectTextMapper myCollectTextMapper;
    @Autowired
    CardMapper cardMapper;
    @Autowired
    TextMapper textMapper;

    @Autowired
    HttpServletRequest httpServletRequest;

    @Override
    public CommonResult<NoData> addCard(Integer cardId) {
        // get device id
        String token = httpServletRequest.getHeader("token");
        Device device = deviceMapper.selectByToken(token);
        // check device
        if (device == null) return CommonResult.fail("该账号不存在");
        // check card id
        Card card = cardMapper.selectByPrimaryKey(cardId);
        if (card == null) return CommonResult.fail("该卡片不存在");
        // add card to personal collect
        // set example
        MyCollectCard myCollectCard = new MyCollectCard();
        myCollectCard.setCardId(cardId);
        myCollectCard.setDeviceId(device.getId());
        myCollectCard.setTime(System.currentTimeMillis());

        // insert
        if (myCollectCardMapper.insert(myCollectCard) == 1) return CommonResult.success();

        // return
        return CommonResult.fail("收藏失败");
    }

    @Override
    public CommonResult<CollectCardsReturn> getCards() {
        // get device id
        String token = httpServletRequest.getHeader("token");
        Device device = deviceMapper.selectByToken(token);
        // check device
        if (device == null) return CommonResult.fail("该账号不存在");

        // search collections
        List<MyCollectCard> myCollectCards = myCollectCardMapper.selectByDeviceId(device.getId());
        if (myCollectCards.isEmpty()) return CommonResult.fail("暂无收藏");

        // return class
        CollectCardsReturn collectCardsReturn = new CollectCardsReturn();
        collectCardsReturn.setTotal(myCollectCards.size());
        for (MyCollectCard myCollectCard : myCollectCards) {
            Card card = cardMapper.selectByPrimaryKey(myCollectCard.getCardId());
            if (card == null) continue;
            collectCardsReturn.getCards().add(card);
        }
        return CommonResult.success(collectCardsReturn);
    }

    @Override
    public CommonResult<NoData> deleteCard(Integer cardId) {
        // get device id
        String token = httpServletRequest.getHeader("token");
        Device device = deviceMapper.selectByToken(token);
        // check device
        if (device == null) return CommonResult.fail("该账号不存在");
        // check card id
        Card card = cardMapper.selectByPrimaryKey(cardId);
        if (card == null) return CommonResult.fail("该卡片不存在");

        if (myCollectCardMapper.deleteByDeviceIdAndCardId(device.getId(), card.getId()) == 1) return CommonResult.success();
        return CommonResult.fail("取消收藏失败");
    }

    @Override
    public CommonResult<NoData> addText(Integer textId) {
        // get device id
        String token = httpServletRequest.getHeader("token");
        Device device = deviceMapper.selectByToken(token);
        // check device
        if (device == null) return CommonResult.fail("该账号不存在");
        // check text id
        Text text = textMapper.selectByPrimaryKey(textId);
        if (text == null) return CommonResult.fail("该文章不存在");
        // add card to personal collect
        // set example
        MyCollectText myCollectText = new MyCollectText();
        myCollectText.setTextId(textId);
        myCollectText.setDeviceId(device.getId());
        myCollectText.setTime(System.currentTimeMillis());

        if (myCollectTextMapper.insert(myCollectText) == 1) return CommonResult.success();
        return CommonResult.fail("收藏失败");
    }

    @Override
    public CommonResult<CollectTextsReturn> getTexts() {
        // get device id
        String token = httpServletRequest.getHeader("token");
        Device device = deviceMapper.selectByToken(token);
        // check device
        if (device == null) return CommonResult.fail("该账号不存在");

        // search collections
        List<MyCollectText> myCollectTexts = myCollectTextMapper.selectByDeviceId(device.getId());
        if (myCollectTexts.isEmpty()) return CommonResult.fail("暂无收藏");

        // return class
        CollectTextsReturn collectTextsReturn = new CollectTextsReturn();
        collectTextsReturn.setTotal(myCollectTexts.size());
        for (MyCollectText myCollectText : myCollectTexts) {
            Text text = textMapper.selectByPrimaryKey(myCollectText.getTextId());
            if (text == null) continue;
            collectTextsReturn.getTexts().add(text);
        }

        return CommonResult.success(collectTextsReturn);
    }

    @Override
    public CommonResult<NoData> deleteText(Integer textId) {
        // get device id
        String token = httpServletRequest.getHeader("token");
        Device device = deviceMapper.selectByToken(token);
        // check device
        if (device == null) return CommonResult.fail("该账号不存在");
        // check text id
        Text text = textMapper.selectByPrimaryKey(textId);
        if (text == null) return CommonResult.fail("该文章不存在");

        if (myCollectTextMapper.deleteByDeviceIdAndTextId(device.getId(), text.getId()) == 1) return CommonResult.success();

        return CommonResult.fail("取消收藏失败");
    }
}