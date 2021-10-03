package com.cointeam.coin.mapper;

import com.cointeam.coin.pojo.domain.MyCollectCard;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyCollectCardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MyCollectCard record);

    int insertSelective(MyCollectCard record);

    MyCollectCard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MyCollectCard record);

    int updateByPrimaryKey(MyCollectCard record);
}