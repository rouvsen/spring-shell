package com.example.springshell;

import org.jline.reader.LineReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class ApplicationConfig {
    @Bean
    CLIExceptionHandler exceptionHandler() {
        return new CLIExceptionHandler();
    }

    @Bean
    public ShellReader shellReader(@Lazy LineReader lineReader) {
        return new ShellReader(lineReader);
    }
}
