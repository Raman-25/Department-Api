package com.project.department_api.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapperconfigs {

    @Bean
    public ModelMapper getModeMapper(){
        return new ModelMapper();
    }
}
