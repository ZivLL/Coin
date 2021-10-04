package com.cointeam.coin.mapper;

import com.cointeam.coin.pojo.domain.AuditBranch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuditBranchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuditBranch record);

    int insertSelective(AuditBranch record);

    int updateByPrimaryKeySelective(AuditBranch record);

    int updateByPrimaryKey(AuditBranch record);

    List<AuditBranch> selectByDeviceId(Integer deviceId);
}