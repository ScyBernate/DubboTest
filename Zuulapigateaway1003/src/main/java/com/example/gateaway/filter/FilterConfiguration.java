package com.example.gateaway.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {

    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }

    @Bean
    public ErrorFilter errorFilter(){
        return new ErrorFilter();
    }

    @Bean
    public AddResFilter addResFilter(){
        return new AddResFilter();
    }

}
