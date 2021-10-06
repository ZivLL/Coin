package com.cointeam.coin.service.impl;

import com.cointeam.coin.mapper.AuditCardMapper;
import com.cointeam.coin.mapper.CardPartMapper;
import com.cointeam.coin.mapper.DeviceMapper;
import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.bo.CardBo;
import com.cointeam.coin.pojo.bo.CardDetailsBo;
import com.cointeam.coin.pojo.domain.AuditCard;
import com.cointeam.coin.pojo.domain.Device;
import com.cointeam.coin.pojo.dto.param.InsertBranchParam;
import com.cointeam.coin.pojo.dto.param.InsertCardParam;
import com.cointeam.coin.pojo.dto.param.RoleParam;
import com.cointeam.coin.pojo.dto.result.CardDetailsResult;
import com.cointeam.coin.pojo.dto.result.CardResult;
import com.cointeam.coin.pojo.dto.result.NoData;
import com.cointeam.coin.pojo.po.CardDetailsPo;
import com.cointeam.coin.pojo.po.CardPo;
import com.cointeam.coin.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author 李春强
 * @Date 2021/10/1 20:14
 * @Param
 * @Return
 * @Description: card实现类
 */
@Service
@Transactional
public class CardServiceImpl implements CardService {

    @Autowired
    CardPartMapper cardPartMapper;
    @Autowired
    HttpServletRequest httpServletRequest;
    @Autowired
    DeviceMapper deviceMapper;
    @Autowired
    AuditCardMapper auditCardMapper;

    /**
     * 卡片展示
     */
    @Override
    public CommonResult selectCard(RoleParam roleParam) {

        CardResult cardResult = new CardResult();
        ArrayList<CardBo> cardBos = new ArrayList<>();
        ArrayList<CardPo> cardPos = cardPartMapper.selectCard(roleParam);

        for (CardPo cardPo : cardPos) {

            CardBo cardBo = new CardBo();

            cardBo.setId(cardPo.getId());
            cardBo.setTitle(cardPo.getTitle());
            cardBo.setContent(cardPo.getContent());
            cardBo.setType(cardPo.getType());

            cardBos.add(cardBo);
        }

        cardResult.setCardBos(cardBos);

        return CommonResult.success(cardResult);
    }

    /**
     * 卡片内容详情（定位到个体）
     */
    @Override
    public CommonResult<CardDetailsResult> selectCardDetails(RoleParam roleParam) {

        CardDetailsResult cardDetailsResult = new CardDetailsResult();
        ArrayList<CardDetailsBo> CardDetailsBos = new ArrayList<>();
        ArrayList<CardDetailsPo> cardContent = cardPartMapper.selectCardContent(roleParam);

        for (CardDetailsPo cardDetailsPo : cardContent) {

            CardDetailsBo cardDetailsBo = new CardDetailsBo();

            Integer branchId = cardDetailsPo.getBranchId();
            String title = cardDetailsPo.getTitle();
            String content = cardDetailsPo.getContent();
            String branchContent = cardDetailsPo.getBranchContent();
            Long branchTime = cardDetailsPo.getBranchTime();

            //时间转换
            String time = transformTime(branchTime);

            cardDetailsBo.setBranchId(branchId);
            cardDetailsBo.setTitle(title);
            cardDetailsBo.setContent(content);
            cardDetailsBo.setBranchContent(branchContent);
            cardDetailsBo.setBranchTime(time);
            cardDetailsBo.setStatus(cardDetailsPo.getStatus());

            CardDetailsBos.add(cardDetailsBo);
        }
        cardDetailsResult.setCardDetailsBos(CardDetailsBos);
        return CommonResult.success(cardDetailsResult);
    }

    /**
     * 提交分支到审核平台
     */
    @Override
    public CommonResult<NoData> insertBranch(InsertBranchParam insertBranchParam) {

        cardPartMapper.insertAuditBranch(insertBranchParam);

        return CommonResult.success("提交成功");
    }

    /**
     * @author ziv
     */
    @Override
    public CommonResult<InsertCardParam> insertCard(InsertCardParam insertCardParam) {
        // check device if exist
        // get device id
        String token = httpServletRequest.getHeader("token");
        Device device = deviceMapper.selectByToken(token);
        // check device
        if (device == null) return CommonResult.fail("该账号不存在");

        // check submit times
        List<AuditCard> auditCards = auditCardMapper.selectByDeviceId(device.getId());
        int times = 0;
        if (!auditCards.isEmpty()) {
            for (AuditCard auditCard : auditCards) {
                if (auditCard.getTime() >= todayZeroTime() && auditCard.getTime() < System.currentTimeMillis()) {
                    times = (int) (times + auditCard.getSubmitTimes());
                }
            }
        }
        if (times >= 5) return CommonResult.fail("今日提交总次数达到5次，请明日再试");

        // set insert example
        AuditCard auditCard = new AuditCard();
        auditCard.setContent(insertCardParam.getContent());
        auditCard.setDeviceId(device.getId());
        auditCard.setTitle(insertCardParam.getTitle());
        auditCard.setStatus(0);
        auditCard.setTime(System.currentTimeMillis());
        auditCard.setType(insertCardParam.getType());


        if (insertCardParam.getId() == null) {
            auditCard.setSubmitTimes(1L);
            // insert
            if (auditCardMapper.insert(auditCard) == 1) {
                insertCardParam.setId(auditCard.getId());
                return CommonResult.success(insertCardParam);
            }
        } else {
            AuditCard auditCard1 = auditCardMapper.selectByPrimaryKey(insertCardParam.getId());
            if (auditCard1 == null) return CommonResult.fail("更新失败");
            Long submitTimes = auditCard1.getSubmitTimes();
            auditCard.setSubmitTimes(submitTimes + 1);
            auditCard.setId(insertCardParam.getId());
            // update
            if (auditCardMapper.updateByPrimaryKey(auditCard) == 1) return CommonResult.success(insertCardParam);
        }

        return CommonResult.fail("提交失败");
    }

    /**
     * 处理时间 毫秒转为字符串 最多精确到分
     * @param time
     * @return
     */
    public String transformTime(Long time){

        //获取当前日期时间
        LocalDateTime now = LocalDateTime.now();

        Date date = new Date(time);

        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");// 格式化时间
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");// 格式化时间
        SimpleDateFormat sdf3 = new SimpleDateFormat("MM.dd");// 格式化时间

        String format = sdf.format(date);
        String format2 = sdf2.format(date);
        String format3 = sdf3.format(date);

        //时间切片
        String[] split = format.split("-", 3);

        //返回时间
        if (new Integer(split[0]) < year){
            return format;
        } else if (new Integer(split[2]) < day - 1){
            return format3;
        } else if (new Integer(split[2]) == day -1){
            return "昨天";
        } else {
            return format2;
        }
    }

    /**
     * @author ziv
     * @return zero time_stamp
     */
    // 今日0点
    // 精确到毫秒的时间戳
    private Long todayZeroTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }
}
