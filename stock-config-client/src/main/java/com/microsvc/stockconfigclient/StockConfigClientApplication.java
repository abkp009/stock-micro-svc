package com.microsvc.stockconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
public class StockConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockConfigClientApplication.class, args);
	}
}
