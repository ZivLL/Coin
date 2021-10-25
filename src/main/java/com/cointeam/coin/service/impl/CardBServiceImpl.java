package com.cointeam.coin.service.impl;

import com.cointeam.coin.mapper.CardMapper;
import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.domain.Card;
import com.cointeam.coin.pojo.dto.param.CardParam;
import com.cointeam.coin.pojo.dto.result.CollectCardsReturn;
import com.cointeam.coin.service.CardBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : ziv_l
 * create at:  2021/10/26  00:32
 * @description: 管理员card实现类
 */
@Service
public class CardBServiceImpl implements CardBService {

    @Autowired
    CardMapper cardMapper;

    @Override
    public CommonResult<Card> cardUpload(CardParam cardParam) {
        // check type number
        if (cardParam.getType() >= 5 || cardParam.getType() <= 0) return CommonResult.fail("type参数错误");

        // make example
        Card card = new Card();
        card.setId(cardParam.getId());
        card.setContent(cardParam.getContent());
        card.setDeviceId(1);
        card.setTime(System.currentTimeMillis());
        card.setTitle(cardParam.getTitle());
        card.setType(cardParam.getType());
        // 区分 id 以判断是否为更新或者插入操作
        // insert when id is null
        if (cardParam.getId() == null) {
            cardMapper.insert(card);
            return CommonResult.success("卡片成功插入数据库", card);
        }
        if (cardParam.getId() <= 0) return CommonResult.fail("id 参数错误");
        if (cardMapper.selectByPrimaryKey(cardParam.getId()) == null) return CommonResult.fail("该卡片不存在，更新失败");
        cardMapper.updateByPrimaryKey(card);
        return CommonResult.success("卡片更新成功", card);
    }

    @Override
    public CommonResult<CollectCardsReturn> getCardList() {

        List<Card> cards = cardMapper.selectByDeviceId(1);
        if (cards.isEmpty()) return CommonResult.fail("数据库暂无管理员上传的文章");

        // 封装返回类
        CollectCardsReturn cardsReturn = new CollectCardsReturn();
        cardsReturn.setCards(cards);
        cardsReturn.setTotal(cards.size());

        return CommonResult.success(cardsReturn);
    }
}