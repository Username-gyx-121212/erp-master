package com.baidu.erpusfrg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baidu.erpusfrg.mapper")
public class ErpUsFrgApplication {
    public static void main(String[] args) {
        SpringApplication.run(ErpUsFrgApplication.class, args);
    }
}
