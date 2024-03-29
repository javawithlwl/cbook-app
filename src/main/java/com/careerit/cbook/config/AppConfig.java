package com.careerit.cbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig {
        @Bean
        public WebMvcConfigurer webConfigurer(){
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
                    registry.addMapping("/**").allowedMethods("*").allowedOrigins("*");
                }
            };
        }

}