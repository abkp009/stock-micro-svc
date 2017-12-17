package com.micsvc.stockservice.stock.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@RestController
@RequestMapping("/rest/stock")
public class StockService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${svc.db.url}")
	private String url;
	

	@GetMapping("/{userName}")
	public List<Stock> getStock(@PathVariable("userName") final String userName) {
		return getDbTemplate(userName)
				.getBody()
				.stream()
				.distinct()
				.sorted()
				.map(this::getStockPrice)
				.collect(Collectors.toList());
	}

	private Stock getStockPrice(String quote) {
		try {
			return YahooFinance.get(quote);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Stock(quote);
	}

	//rest call to other micro service
	private ResponseEntity<List<String>> getDbTemplate(String userName) {
		return restTemplate.exchange(url + userName, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<String>>() {
				});

	}
}
