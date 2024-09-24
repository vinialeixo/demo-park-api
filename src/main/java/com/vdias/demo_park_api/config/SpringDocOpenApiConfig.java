package com.vdias.demo_park_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SpringDocOpenApiConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(
            new Info()
                .title("Rest Api - Spring Park")
                .description("Api para gestão de estacionamento de veiculos")
                .version("v1")
                
        );
    }
}
