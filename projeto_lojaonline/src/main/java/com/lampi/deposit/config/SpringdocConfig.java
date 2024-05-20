package com.lampi.deposit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
// COISA QUE TEM NA INTERFACE DO SWAGGER
@Configuration
public class SpringdocConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
            .info(new Info()
                .title("API Test Testada")
                .version("V0.1")
                .license(new License()
                .name("nome da cois")
                .url("http://springdoc.com"))
            );
    }
}
