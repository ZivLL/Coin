package com.cointeam.coin.pojo.dto.result;

import com.cointeam.coin.pojo.domain.Text;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ziv_l
 * create at:  2021/10/1  23:47
 * @description: 收藏文章返回类
 */
@Data
@ApiModel
public class CollectTextsReturn {

    private Integer total;

    private List<Text> texts = new ArrayList<>();
}