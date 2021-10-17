package com.cointeam.coin.mapper;

import com.cointeam.coin.pojo.domain.AuditBranch;
import com.cointeam.coin.pojo.domain.AuditCard;
import com.cointeam.coin.pojo.domain.Branch;
import com.cointeam.coin.pojo.domain.Card;
import com.cointeam.coin.pojo.dto.param.CardBranchVerifyWebParam;
import com.cointeam.coin.pojo.dto.param.InsertCardBranchToBranchParam;
import com.cointeam.coin.pojo.po.CardBranchVerifyWebPo;
import com.cointeam.coin.pojo.po.CardWebPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface CardWebMapper {

    ArrayList<CardBranchVerifyWebPo> selectCardBranchVerifyWeb(@Param("cardBranchVerifyWebParam") CardBranchVerifyWebParam cardBranchVerifyWebParam);

    ArrayList<CardWebPo> selectCardWeb(@Param("cardBranchVerifyWebParam") CardBranchVerifyWebParam cardBranchVerifyWebParam);

    String selectNickNameByDeviceId(@Param("deviceId") Integer deviceId);

    String selectTitleByCardId(@Param("cardId") Integer cardId);

    void updateWebStatus(@Param("cardBranchVerifyWebParam") CardBranchVerifyWebParam cardBranchVerifyWebParam);

    void updateCardWebStatus(@Param("cardBranchVerifyWebParam") CardBranchVerifyWebParam cardBranchVerifyWebParam);

    ArrayList<AuditBranch> selectBranchById(@Param("cardBranchVerifyWebParam") CardBranchVerifyWebParam cardBranchVerifyWebParam);

    ArrayList<AuditCard> selectAuditCardId(@Param("cardBranchVerifyWebParam") CardBranchVerifyWebParam cardBranchVerifyWebParam);

    void insertCardBranch(@Param("auditBranches") ArrayList<AuditBranch> auditBranches);

    void insertCard(@Param("card") ArrayList<AuditCard> card);
}
