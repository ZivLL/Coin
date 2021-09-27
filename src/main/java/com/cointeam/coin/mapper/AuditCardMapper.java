package com.cointeam.coin.mapper;

import com.cointeam.coin.pojo.domain.AuditCard;

public interface AuditCardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuditCard record);

    int insertSelective(AuditCard record);

    AuditCard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuditCard record);

    int updateByPrimaryKey(AuditCard record);
}