package com.example.urlshortenerlb.Configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RibbonTemplateConfiguration {
    @LoadBalanced
    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
