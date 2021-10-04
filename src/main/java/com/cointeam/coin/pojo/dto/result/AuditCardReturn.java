package com.cointeam.coin.pojo.dto.result;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ziv_l
 * create at:  2021/10/4  11:25
 * @description: 我的分享返回类（card）
 */
@Data
@ApiModel
public class AuditCardReturn {

    private Integer total;

    List<AuditCard> auditCards = new ArrayList<>();

    @Data
    private static class AuditCard{

        private String title;

        private String content;

        private Integer type;

        private Integer status;

        private Long time;
    }
}