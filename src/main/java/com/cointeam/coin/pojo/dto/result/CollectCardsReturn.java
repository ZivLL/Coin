package com.cointeam.coin.pojo.dto.result;

import com.cointeam.coin.pojo.domain.Card;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ziv_l
 * create at:  2021/9/30  15:14
 * @description: 收藏列表返回类
 */
@Data
@ApiModel
public class CollectCardsReturn {

    private Integer total;

    private List<Card> cards = new ArrayList<>();
}