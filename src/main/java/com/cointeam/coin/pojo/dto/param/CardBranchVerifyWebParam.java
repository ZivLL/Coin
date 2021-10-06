package com.cointeam.coin.pojo.dto.param;

import lombok.Data;

import java.util.ArrayList;

@Data
public class CardBranchVerifyWebParam {

    private ArrayList<Integer> id;

    private Integer status;

}
