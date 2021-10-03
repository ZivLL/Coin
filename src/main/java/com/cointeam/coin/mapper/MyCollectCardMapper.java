package com.cointeam.coin.mapper;

import com.cointeam.coin.pojo.domain.MyCollectCard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyCollectCardMapper {
    int deleteByDeviceIdAndCardId(Integer deviceId, Integer cardId);

    int insert(MyCollectCard record);

    int insertSelective(MyCollectCard record);

    MyCollectCard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MyCollectCard record);

    int updateByPrimaryKey(MyCollectCard record);

    List<MyCollectCard> selectByDeviceId(Integer deviceId);
}