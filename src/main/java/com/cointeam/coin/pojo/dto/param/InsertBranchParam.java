package com.cointeam.coin.pojo.dto.param;

import lombok.Data;

/**
 * @Author 李春强
 * @Date 2021/10/2 21:22
 * @Param
 * @Return
 * @Description: 分支提交到审核平台参数类
 */
@Data
public class InsertBranchParam {

    /**
     * 设备id
     */
    private Integer deviceId;

    /**
     * 卡片id
     */
    private Integer cardId;

    /**
     * 卡片内容
     */
    private String branchContent;

    /**
     * 人群分类
     */
    private Integer type;

    /**
     * 提交分支的审核状态
     */
    private Integer status;

    /**
     * 分支提交到审核平台的时间
     */
    private Long time;

    /**
     * 分支提交次数
     */
    private Long submitTime;

}
