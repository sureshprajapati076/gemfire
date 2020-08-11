package com.example.gemfiree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GemfireeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GemfireeApplication.class, args);
    }

}
