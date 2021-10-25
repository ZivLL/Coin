package com.cointeam.coin.mapper;

import com.cointeam.coin.pojo.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @Author 李春强
 * @Date 2021/10/17 19:47
 * @Param
 * @Return
 * @Description: ItemCF
 */
@Mapper
public interface ItemCFMapper {

    String selectUserIdByDeviceId(@Param("deviceId") Integer deviceId);

    ArrayList<Card> selectAllCard();

    ArrayList<Text> selectAllText();

    ArrayList<Device> selectAllDevice();

    ArrayList<MyCollectCard> selectAllMyCollectCard();

    ArrayList<MyCollectCard> selectMyCollectCard(@Param("UserId") String UserId);

    ArrayList<MyCollectText> selectMyCollectText(@Param("UserId") String UserId);

    Integer selectCollectNumber();

}
