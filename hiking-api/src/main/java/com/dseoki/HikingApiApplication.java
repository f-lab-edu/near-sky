package com.dseoki.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class HikingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HikingApiApplication.class, args);
    }

}
