package dev.opoussa.todo_app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.service.registry.ImportHttpServices;

import dev.opoussa.todo_app.client.ITodoClient;

@Configuration
@ImportHttpServices(
    basePackages = "dev.opoussa.todo_app.client",
    types = ITodoClient.class
)
public class HttpClientConfig {}
