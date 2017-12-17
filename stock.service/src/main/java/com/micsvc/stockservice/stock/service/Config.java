package com.micsvc.stockservice.stock.service;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

	@LoadBalanced
	@Bean
	public RestTemplate getTempate(){
		return new RestTemplate(); 
	}
	
}
