package com.cointeam.coin.mapper;

import com.cointeam.coin.pojo.dto.param.CardBranchVerifyWebParam;
import com.cointeam.coin.pojo.po.CardBranchVerifyWebPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface CardWebMapper {

    ArrayList<CardBranchVerifyWebPo> selectCardBranchVerifyWeb(@Param("cardBranchVerifyWebParam") CardBranchVerifyWebParam cardBranchVerifyWebParam);

    String selectNickNameByDeviceId(@Param("deviceId") Integer deviceId);

    String selectTitleByCardId(@Param("cardId") Integer cardId);

    void updateWebStatus(@Param("cardBranchVerifyWebParam") CardBranchVerifyWebParam cardBranchVerifyWebParam);
}
