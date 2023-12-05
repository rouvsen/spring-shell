package com.example.springshell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.shell.command.annotation.CommandScan;

@SpringBootApplication
@EnableFeignClients
@CommandScan
public class SpringShellApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringShellApplication.class, args);
    }

}
