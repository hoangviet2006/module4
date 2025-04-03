package com.example.luyen_tap_blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config {

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("http://localhost:63343") // Chỉ định domain được phép
//                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Các method được phép
//                        .allowedHeaders("*") // Cho phép tất cả các header
//                        .allowCredentials(true); // Cho phép gửi credentials (nếu có đăng nhập)
//            }
//        };
//    }
}

