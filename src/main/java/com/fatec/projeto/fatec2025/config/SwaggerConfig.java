package com.fatec.projeto.fatec2025.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    
    //http://127.0.0.1:8080/swagger-ui/index.html
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
            .info(new Info()
                .title("API Projeto 2025")
                .version("0.1")
                .description("Documentação da API do projeto 2025 - Semestre 1")
            );
            
    }
}
