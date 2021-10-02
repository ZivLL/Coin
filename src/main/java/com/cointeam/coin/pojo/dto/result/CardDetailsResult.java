package com.cointeam.coin.pojo.dto.result;

import com.cointeam.coin.pojo.bo.CardDetailsBo;
import lombok.Data;

import java.util.ArrayList;

@Data
public class CardDetailsResult {

    ArrayList<CardDetailsBo> cardDetailsBos;

}
