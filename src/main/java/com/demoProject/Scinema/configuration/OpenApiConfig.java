package com.demoProject.Scinema.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "User API", version = "v1", description = "API quản lý người dùng"))
public class OpenApiConfig {
}
