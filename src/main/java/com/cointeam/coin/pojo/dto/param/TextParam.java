package com.cointeam.coin.pojo.dto.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author : ziv_l
 * create at:  2021/9/28  20:55
 * @description: 文章传输类
 */
@Data
@ApiModel
public class TextParam {

    private Integer id;

    @NotNull(message = "不能为空")
    private String title;

    @NotNull(message = "不能为空")
    private String author;

    @NotNull(message = "不能为空")
    private String content;

    @NotNull(message = "不能为空")
    private String picUrl;

    @NotNull(message = "不能为空")
    private Long time;

    @NotNull(message = "不能为空")
    private Integer type;
}