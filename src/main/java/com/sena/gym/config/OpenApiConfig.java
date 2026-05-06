package com.sena.gym.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/** Configura el titulo que aparece en Swagger UI. */
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI gymOpenAPI() {
        return new OpenAPI().info(new Info().title("Gym API").version("1.0.0").description("API REST para miembros, entrenadores y sesiones de entrenamiento."));
    }
}
