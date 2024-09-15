package com.atguigu.common.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:TODO
 * @Author: dansheng
 * @CreateTime: 2024/9/15
 **/

@Configuration
@MapperScan("com.atguigu.web.*.mapper")
public class MybatisPlusConfiguration {

}
