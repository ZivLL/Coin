package com.cointeam.coin.service;

import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.domain.Card;
import com.cointeam.coin.pojo.dto.param.CardParam;
import com.cointeam.coin.pojo.dto.result.CollectCardsReturn;

public interface CardBService {

    CommonResult<Card> cardUpload(CardParam cardParam);

    CommonResult<CollectCardsReturn> getCardList();
}
