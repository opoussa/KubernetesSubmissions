package dev.opoussa.read_service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.service.registry.ImportHttpServices;

import dev.opoussa.read_service.client.IPingClient;

@Configuration
@ImportHttpServices(
    basePackages = "dev.opoussa.read_service.client", 
    types = IPingClient.class
)
public class HttpClientConfig {

}
