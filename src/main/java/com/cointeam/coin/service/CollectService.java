package com.cointeam.coin.service;

import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.result.CollectCardsReturn;
import com.cointeam.coin.pojo.dto.result.CollectTextsReturn;
import com.cointeam.coin.pojo.dto.result.NoData;

public interface CollectService {

    // card
    CommonResult<NoData> addCard(Integer cardId);

    CommonResult<CollectCardsReturn> getCards();

    CommonResult<NoData> deleteCard(Integer cardId);

    // text
    CommonResult<NoData> addText(Integer textId);

    CommonResult<CollectTextsReturn> getTexts();

    CommonResult<NoData> deleteText(Integer textId);
}
