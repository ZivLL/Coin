package com.cointeam.coin.mapper;

import com.cointeam.coin.pojo.domain.Text;

public interface TextMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Text record);

    int insertSelective(Text record);

    Text selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Text record);

    int updateByPrimaryKey(Text record);
}