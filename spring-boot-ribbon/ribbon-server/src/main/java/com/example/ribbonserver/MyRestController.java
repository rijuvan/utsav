package com.example.ribbonserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyRestController {

	@Autowired
	Environment environment;
	 

	@GetMapping("/")
	public String health() {
		return "I am Ok";
	}

	@GetMapping("/backend")
	public String backend() {
		System.out.println("Inside MyRestController::backend...");
		// String randomString = this.restTemplate.getForObject("http://ConsumerService/backend", String.class);
		// System.out.println("Inside Customer Services............"+randomString+"....................");
		String serverPort = environment.getProperty("local.server.port");

		System.out.println("Port : " + serverPort);
		
		return "Hello form Backend!!! " + " Host : localhost " + " :: Port : " + serverPort;
	}
}
