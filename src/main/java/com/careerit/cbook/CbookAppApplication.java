package com.careerit.cbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class CbookAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CbookAppApplication.class, args);
	}

	@Scheduled(cron = "0 */5 * ? * *")
	public void greet() {
		RestTemplate restTemplate = new RestTemplate();
		String message = restTemplate.getForObject("http://localhost:8081/api/contact/hello", String.class);
		System.out.println(message);
	}

}
