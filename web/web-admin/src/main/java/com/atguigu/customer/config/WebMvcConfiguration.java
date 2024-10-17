package com.atguigu.customer.config;

import com.atguigu.customer.interceptor.AuthenticationInterceptor;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: WebMvc配置.
 * @Author: dansheng
 * @CreateTime: 2024/10/15
 **/
@Configuration
@Schema(description = "WebMvc配置")
@RequiredArgsConstructor
public class WebMvcConfiguration implements WebMvcConfigurer {

    private final AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(this.authenticationInterceptor).addPathPatterns("/admin/**").excludePathPatterns("/admin/login/**");
//        registry.addInterceptor(this.authenticationInterceptor)
//                .addPathPatterns("/admin/**")
//                .excludePathPatterns("/admin");
    }
}
