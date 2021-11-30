package com.lunchbox.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(value = {
        "com.lunchbox.customer.dto",
        "com.lunchbox.customer.controller",
        "com.lunchbox.customer.service",
        "com.lunchbox.customer.service.impl",
        "com.lunchbox.customer.repository",
        "com.lunchbox.customer.repository.entity"})
@EnableDiscoveryClient
public class CustomerManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerManagementApplication.class, args);
    }

}


