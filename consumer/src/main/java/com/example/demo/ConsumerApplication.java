package com.example.demo;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class ConsumerApplication {

	@Bean
    @LoadBalanced
	RestTemplate restTemplate(){
	    return new RestTemplate();
	}


	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/getKs")
	public String getKs(){
	    return restTemplate.getForObject("http://server/ks",String.class);
	}

}
