package com.cointeam.coin.pojo.dto.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author : ziv_l
 * create at:  2021/10/4  16:07
 * @description: 提交卡片参数类
 */
@Data
@ApiModel
public class InsertCardParam {

    private Integer id;

    @NotNull(message = "不能为空")
    private String title;

    @NotNull(message = "不能为空")
    private String content;

    @NotNull(message = "不能为空")
    private Integer type;

}