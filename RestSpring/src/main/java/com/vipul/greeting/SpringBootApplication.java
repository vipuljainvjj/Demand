package com.vipul.greeting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SpringBootApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject("https://quoters.apps.pcfone.io/api/random", Quote.class);
			System.out.println("It is running");
			System.out.println(quote.toString());
			log.info(quote.toString());
		};
	}
}