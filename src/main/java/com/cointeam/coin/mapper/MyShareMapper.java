package com.cointeam.coin.mapper;

import com.cointeam.coin.pojo.domain.MyShare;

public interface MyShareMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MyShare record);

    int insertSelective(MyShare record);

    MyShare selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MyShare record);

    int updateByPrimaryKey(MyShare record);
}