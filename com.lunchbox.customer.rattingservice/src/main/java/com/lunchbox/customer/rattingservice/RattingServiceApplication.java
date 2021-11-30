package com.lunchbox.customer.rattingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(value = {
        "com.lunchbox.customer.rattingservice.dto",
        "com.lunchbox.customer.rattingservice.controller",
        "com.lunchbox.customer.rattingservice.service",
        "com.lunchbox.customer.rattingservice.service.impl",
        "com.lunchbox.customer.rattingservice.repository",
        "com.lunchbox.customer.rattingservice.repository.entity"})
public class RattingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RattingServiceApplication.class, args);
    }

}
