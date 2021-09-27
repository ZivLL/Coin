package com.cointeam.coin.mapper;

import com.cointeam.coin.pojo.domain.AuditBranch;

public interface AuditBranchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuditBranch record);

    int insertSelective(AuditBranch record);

    AuditBranch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuditBranch record);

    int updateByPrimaryKey(AuditBranch record);
}