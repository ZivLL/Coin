package com.cointeam.coin.service.impl;

import com.cointeam.coin.mapper.*;
import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.bo.CardDetailsBo;
import com.cointeam.coin.pojo.domain.AuditBranch;
import com.cointeam.coin.pojo.domain.AuditCard;
import com.cointeam.coin.pojo.domain.Card;
import com.cointeam.coin.pojo.domain.Device;
import com.cointeam.coin.pojo.dto.result.AuditBranchReturn;
import com.cointeam.coin.pojo.dto.result.AuditCardReturn;
import com.cointeam.coin.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author : ziv_l
 * create at:  2021/10/4  11:17
 * @description: 我的分享功能实现类
 */
@Service
public class AuditServiceImpl implements AuditService {

    @Autowired
    DeviceMapper deviceMapper;
    @Autowired
    AuditBranchMapper auditBranchMapper;
    @Autowired
    AuditCardMapper auditCardMapper;
    @Autowired
    CardMapper cardMapper;
    @Autowired
    CardPartMapper cardPartMapper;

    @Autowired
    HttpServletRequest httpServletRequest;

    @Override
    public CommonResult<AuditCardReturn> getAuditingCards() {
        // get device id
        String token = httpServletRequest.getHeader("token");
        Device device = deviceMapper.selectByToken(token);
        // check device
        if (device == null) return CommonResult.fail("该账号不存在");

        List<AuditCard> auditCards = auditCardMapper.selectByDeviceId(device.getId());
        if (auditCards.isEmpty()) return CommonResult.fail("暂无分享的卡片");

        // set return example
        AuditCardReturn auditCardReturn = new AuditCardReturn();
        auditCardReturn.setTotal(auditCards.size());
        for (AuditCard auditCard : auditCards) {
            AuditCardReturn.AuditCard temp = new AuditCardReturn.AuditCard();
            temp.setContent(auditCard.getContent());
            temp.setStatus(auditCard.getStatus());
            temp.setTime(auditCard.getTime());
            temp.setType(auditCard.getType());
            temp.setTitle(auditCard.getTitle());
            auditCardReturn.getAuditCards().add(temp);
        }

        // return
        return CommonResult.success(auditCardReturn);
    }

    @Override
    public CommonResult<AuditBranchReturn> getAuditingBranch() {
        // get device id
        String token = httpServletRequest.getHeader("token");
        Device device = deviceMapper.selectByToken(token);
        // check device
        if (device == null) return CommonResult.fail("该账号不存在");

        List<AuditBranch> auditBranches = auditBranchMapper.selectByDeviceId(device.getId());
        if (auditBranches.isEmpty()) return CommonResult.fail("暂无分享");

        // return class and total
        AuditBranchReturn auditBranchReturn = new AuditBranchReturn();
        auditBranchReturn.setTotal(auditBranches.size());
        // for each
        for (AuditBranch auditBranch : auditBranches) {
            AuditBranchReturn.AuditBranch temp = new AuditBranchReturn.AuditBranch();
            Card card = cardMapper.selectByPrimaryKey(auditBranch.getCardId());
            if (card == null) {
                auditBranchReturn.setTotal(auditBranchReturn.getTotal() - 1);
                continue;
            }
            // card
            temp.setCard(card);
            // cardDetailsBos
            List<CardDetailsBo> cardDetailsBos = cardPartMapper.selectCarBranches(auditBranch.getCardId());
            if (cardDetailsBos.isEmpty()) continue;
            temp.setCardDetailsBos(cardDetailsBos);
            // MyBranches
            AuditBranchReturn.MyBranch  myBranch = new AuditBranchReturn.MyBranch();
            myBranch.setTime(auditBranch.getTime());
            myBranch.setContent(auditBranch.getContent());
            myBranch.setStatus(auditBranch.getStatus());
            myBranch.setType(auditBranch.getType());
            temp.setMyBranch(myBranch);
        }

        return CommonResult.success(auditBranchReturn);
    }
}