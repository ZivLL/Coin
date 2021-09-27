package com.cointeam.coin.mapper;

import com.cointeam.coin.pojo.domain.MyCollectText;

public interface MyCollectTextMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MyCollectText record);

    int insertSelective(MyCollectText record);

    MyCollectText selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MyCollectText record);

    int updateByPrimaryKey(MyCollectText record);
}