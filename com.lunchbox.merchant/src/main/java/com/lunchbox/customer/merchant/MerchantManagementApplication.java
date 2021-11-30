package com.lunchbox.customer.merchant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableAutoConfiguration
@EnableHypermediaSupport(type = { EnableHypermediaSupport.HypermediaType.HAL })
public class MerchantManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MerchantManagementApplication.class, args);
	}

}
