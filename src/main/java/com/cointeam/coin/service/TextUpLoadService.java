package com.cointeam.coin.service;

import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.domain.Text;
import com.cointeam.coin.pojo.dto.param.TextParam;

/**
 * @author : ziv_l
 * create at:  2021/9/28  20:50
 * @description: text上传
 */
public interface TextUpLoadService {

    CommonResult<Text> textUpload(TextParam textParam);
}