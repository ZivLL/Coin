package com.cointeam.coin.pojo.dto.result;

import com.cointeam.coin.pojo.domain.Text;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ziv_l
 * create at:  2021/10/25  23:39
 * @description: 文章列表返回参数（B端）
 */
@Data
@ApiModel
public class TextListReturn {

    private Integer total;

    private List<Text> texts = new ArrayList<>();
}