package com.cointeam.coin.mapper;

import com.cointeam.coin.pojo.domain.MyCollectText;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyCollectTextMapper {
    int deleteByDeviceIdAndTextId(Integer deviceId, Integer textId);

    int insert(MyCollectText record);

    int insertSelective(MyCollectText record);

    MyCollectText selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MyCollectText record);

    int updateByPrimaryKey(MyCollectText record);

    List<MyCollectText> selectByDeviceId(Integer deviceId);
}