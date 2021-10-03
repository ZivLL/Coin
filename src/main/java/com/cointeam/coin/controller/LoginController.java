package com.cointeam.coin.controller;


import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.param.LoginParam;
import com.cointeam.coin.pojo.dto.result.LoginAuthResult;
import com.cointeam.coin.service.LoginService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@Slf4j
@Api(tags = "login：李春强")
@CrossOrigin
public class LoginController{


    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public CommonResult<LoginAuthResult> login(@RequestBody LoginParam loginParam) {
        return loginService.login(loginParam);
    }

}