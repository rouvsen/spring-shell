package com.example.springshell;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    CLIExceptionHandler exceptionHandler() {
        return new CLIExceptionHandler();
    }
}
