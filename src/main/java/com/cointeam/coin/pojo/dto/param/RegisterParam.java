package com.cointeam.coin.pojo.dto.param;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class RegisterParam {

    private String nickName;

    @Pattern(regexp = "^1[3-9]\\\\d{9}$",message = "不符合规范")
    private String userId;

    private String password;

}
