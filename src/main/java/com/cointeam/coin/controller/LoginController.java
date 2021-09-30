package com.cointeam.coin.controller;


import com.cointeam.coin.pojo.CommonResult;
import com.cointeam.coin.pojo.dto.param.LoginParam;
import com.cointeam.coin.pojo.dto.result.NoData;
import com.cointeam.coin.service.LoginService;
import com.sun.corba.se.impl.orbutil.graph.NodeData;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@Slf4j
@Api(tags = "login：李春强")
@CrossOrigin
public class LoginController{


    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public CommonResult<HashMap<String, Object>> login(@RequestBody LoginParam loginParam) {
        return loginService.login(loginParam);
    }

}