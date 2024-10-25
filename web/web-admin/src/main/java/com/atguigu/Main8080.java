package com.atguigu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
@MapperScan("com.atguigu.mapper")
public class Main8080 {

    public static void main(String[] args) {
        SpringApplication.run(Main8080.class, args);
    }

}