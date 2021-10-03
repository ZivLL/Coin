package com.cointeam.coin.controller;


import com.cointeam.coin.annotation.PassToken;
import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.param.LoginParam;
<<<<<<< Updated upstream
import com.cointeam.coin.pojo.dto.result.LoginAuthResult;
import com.cointeam.coin.pojo.dto.result.NoData;
=======
>>>>>>> Stashed changes
import com.cointeam.coin.service.LoginService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


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