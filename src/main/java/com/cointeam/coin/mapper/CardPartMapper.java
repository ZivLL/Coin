package com.cointeam.coin.mapper;

import com.cointeam.coin.pojo.dto.param.InsertBranchParam;
import com.cointeam.coin.pojo.dto.param.RoleParam;
import com.cointeam.coin.pojo.po.CardDetailsPo;
import com.cointeam.coin.pojo.po.CardPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 李春强
 * @Date 2021/9/28 9:00
 * @Param
 * @Return
 * @Description:
 */
@Mapper
public interface CardPartMapper {

    ArrayList<CardPo> selectCard(@Param("roleParam") RoleParam roleParam);

    ArrayList<CardDetailsPo> selectCardContent(@Param("roleParam") RoleParam roleParam);

    void insertAuditBranch(@Param("insertBranchParam") InsertBranchParam insertBranchParam);

}
