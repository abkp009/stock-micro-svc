package com.microsvc.stockconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/rest")
public class MessageResource {

	@Value("${message: Default Hello}")
	private String message;
	@Value("${url: Default Hello}")
	private String url;
	@Value("${brokerUrl: Default Hello}")
	private String brokerUrl;

	@GetMapping("/message")
	public String message() {
		return this.toString();
	}

	@Override
	public String toString() {
		return "MessageResource [message=" + message + ", url=" + url + ", brokerUrl=" + brokerUrl + "]";
	}
}
