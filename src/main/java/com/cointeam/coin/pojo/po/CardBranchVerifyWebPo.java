package com.cointeam.coin.pojo.po;

import lombok.Data;

@Data
public class CardBranchVerifyWebPo {

    private Long Time;

    private Integer id;

    private Integer deviceId;

    private Integer cardId;

    private String content;

    private Integer type;

    private Integer status;

    private Long submitTimes;
}
