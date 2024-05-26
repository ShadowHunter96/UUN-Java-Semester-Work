package com.example.SubjectApi2.config;

/**
 * Created by User: Vu
 * Date: 26.05.2024
 * Time: 10:17
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}