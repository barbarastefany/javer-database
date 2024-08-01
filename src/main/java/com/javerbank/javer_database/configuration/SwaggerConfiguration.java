package com.javerbank.javer_database.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customAPI() {
        return new OpenAPI().info(new Info().title("Javer Database").version("1.0.0").description("Aplicação que realiza operações CRUD de requisições REST enviadas a partir da aplicação javer-api."));

    }
}
