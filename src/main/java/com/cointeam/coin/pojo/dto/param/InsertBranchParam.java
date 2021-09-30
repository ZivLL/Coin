package com.cointeam.coin.pojo.dto.param;

import lombok.Data;

@Data
public class InsertBranchParam {

    private Integer cardId;

    private String branchContent;

    private Long submitTime;

}
