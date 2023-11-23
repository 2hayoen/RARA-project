package com.rara.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 'dailyRecords' 경로로 들어오는 요청을 'C:/devs/files/dailyRecords/' 폴더로 매핑
        registry.addResourceHandler("/devs/files/dailyRecords/**")
                .addResourceLocations("file:///C:/devs/files/dailyRecords/");
    }
}