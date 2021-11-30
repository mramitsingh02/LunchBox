package com.lunchbox.configuration.naming.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaServer
@ComponentScan(
        value = "com.lunchbox.configuration.naming.server"
)
public class NetflixEurekaNamingServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixEurekaNamingServerApplication.class, args);
        System.out.println("Netflix Eureka NamingServer Application stared successful....");
    }

}