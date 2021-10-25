package com.cointeam.coin.controller;


import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.param.RegisterParam;
import com.cointeam.coin.pojo.dto.result.NoData;
import com.cointeam.coin.service.RegisterService;
import io.swagger.annotations.Api;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Api(tags = "注册：李春强")
@CrossOrigin
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @Synchronized
    @PostMapping("/Register")
    public CommonResult<NoData> register(@RequestBody RegisterParam registerParam){
        return registerService.Register(registerParam);
    }

}
