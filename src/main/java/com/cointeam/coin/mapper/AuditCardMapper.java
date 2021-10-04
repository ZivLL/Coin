package com.cointeam.coin.mapper;

import com.cointeam.coin.pojo.domain.AuditCard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuditCardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuditCard record);

    int insertSelective(AuditCard record);

    List<AuditCard> selectByDeviceId(Integer deviceId);

    int updateByPrimaryKeySelective(AuditCard record);

    int updateByPrimaryKey(AuditCard record);
}