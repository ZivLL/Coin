package com.cointeam.coin.mapper;

import com.cointeam.coin.pojo.domain.Text;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TextMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Text record);

    int insertSelective(Text record);

    Text selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Text record);

    int updateByPrimaryKey(Text record);
}