package com.cointeam.coin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;
import springfox.documentation.oas.annotations.EnableOpenApi;

@MapperScan("com.cointeam.mapper")
@SpringBootApplication
@CrossOrigin
@EnableOpenApi
@EnableScheduling
public class CoinApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoinApplication.class, args);
    }

}
