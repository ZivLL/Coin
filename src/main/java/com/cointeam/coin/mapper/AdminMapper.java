package com.cointeam.coin.mapper;

import com.cointeam.coin.pojo.domain.Admin;
import com.cointeam.coin.pojo.dto.param.LoginParam;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    /**
     * 李春强
     */
    Admin findAdmin(@Param("loginParam")LoginParam loginParam);
}