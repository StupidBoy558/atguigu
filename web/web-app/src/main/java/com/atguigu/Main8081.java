package com.atguigu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.atguigu.mapper")
@EnableAsync
public class Main8081 {
    public static void main(String[] args) {
        SpringApplication.run(Main8081.class, args);
    }
}