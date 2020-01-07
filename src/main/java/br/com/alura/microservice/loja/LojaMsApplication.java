package br.com.alura.microservice.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class LojaMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaMsApplication.class, args);
	}
	
	@LoadBalanced //Ribbon  (client side load balance) - a loja faz cada requisição para uma instancia de fornecedor diferente 
	@Bean //gerenciado pelo spring para que seja possível injetar em outras classes
	public RestTemplate getRestTemplate() {//o restTemplate consegue agora resolver as urls:portas dos serviços (trocando por ip)
		return new RestTemplate();
	}

}
