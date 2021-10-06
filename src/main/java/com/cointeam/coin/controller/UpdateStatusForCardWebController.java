package com.cointeam.coin.controller;

import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.param.CardBranchVerifyWebParam;
import com.cointeam.coin.pojo.dto.result.NoData;
import com.cointeam.coin.service.UpdateStatusForCardWebService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "cardWeb：李春强")
@CrossOrigin
@RestController
public class UpdateStatusForCardWebController {

    @Autowired
    UpdateStatusForCardWebService updateStatusForCardWebService;

    @PostMapping("/updateWebStatus")
    public CommonResult<NoData> UpdateStatusForCardWeb(@RequestBody CardBranchVerifyWebParam cardBranchVerifyWebParam){

        return updateStatusForCardWebService.UpdateStatusForCardWeb(cardBranchVerifyWebParam);

    }


}
