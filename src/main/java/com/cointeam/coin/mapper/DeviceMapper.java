package com.cointeam.coin.mapper;

import com.cointeam.coin.pojo.domain.Device;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeviceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);

    Device selectByToken(String token);
}