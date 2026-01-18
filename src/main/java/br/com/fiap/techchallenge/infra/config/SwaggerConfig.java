package br.com.fiap.techchallenge.infra.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API JavaEats",
                version = "v1",
                description = "API responsável pelo gerenciamento de restaurantes"
        )
)
public class SwaggerConfig {
}
