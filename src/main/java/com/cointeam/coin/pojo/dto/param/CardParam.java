package com.cointeam.coin.pojo.dto.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author : ziv_l
 * create at:  2021/10/26  00:27
 * @description: 卡片传输类
 */
@Data
@ApiModel
public class CardParam {

    private Integer id;

    @NotNull(message = "不能为空")
    private String title;

    @NotNull(message = "不能为空")
    private String content;

    @NotNull(message = "不能为空")
    private Integer type;

}