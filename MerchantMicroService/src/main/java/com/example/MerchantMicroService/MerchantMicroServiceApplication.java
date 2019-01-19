package com.example.MerchantMicroService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MerchantMicroServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MerchantMicroServiceApplication.class, args);
	}



	@Override
	public void run(String... strings) throws Exception {
		//System.out.println("hello");
		RestTemplate restTemplate=new RestTemplate();
		String resourceUrl="http://gturnquist-quoters.cfapps.io/api/random";
        ResponseEntity<Quote> quote=restTemplate.exchange(resourceUrl,HttpMethod.GET,null,Quote.class);
		System.out.println(quote.getBody().getType());
		System.out.println(quote.getBody().getValue().getQuote());


	}
}

