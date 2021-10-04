package com.cointeam.coin.pojo.dto.result;

import com.cointeam.coin.pojo.bo.CardDetailsBo;
import com.cointeam.coin.pojo.domain.Card;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ziv_l
 * create at:  2021/10/4  11:29
 * @description: 我的分享返回类（text）
 */
@Data
@ApiModel
public class AuditBranchReturn {

    private Integer total;

    private List<AuditBranch> auditBranches = new ArrayList<>();

    @Data
    public static class AuditBranch{
        private Card card;

        private List<CardDetailsBo> cardDetailsBos = new ArrayList<>();

        private MyBranch myBranch;
    }
    @Data
    public static class MyBranch{

        private String content;

        private Integer type;

        private Integer status;

        private Long time;
    }
}