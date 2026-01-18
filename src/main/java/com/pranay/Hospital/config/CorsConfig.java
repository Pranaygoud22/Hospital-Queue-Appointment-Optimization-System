package com.pranay.Hospital.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/hospital/api/**") // your full backend path
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("*") // GET, POST, PUT, DELETE
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
