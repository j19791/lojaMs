package br.com.alura.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import org.springframework.cloud.client.discovery.DiscoveryClient;

import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.controller.dto.InfoFornecedorDTO;


@Service
public class CompraService {

	
	@Autowired
	private RestTemplate client;
	
	@Autowired
	private DiscoveryClient eurekaClient; //atenção: não importar a lib do com.netflix.discovery.DiscoveryClient
	
	public void realizaCompra(CompraDTO compra) {
		
	//	RestTemplate client = new RestTemplate(); //faz requisições para outro MS
		
		ResponseEntity<InfoFornecedorDTO> exchange = client.exchange(
				"http://fornecedor/info/" + compra.getEndereco().getEstado(), //porta 8081 é a porta do ms do fornecedor
				HttpMethod.GET, //receber informações
				null, 
				InfoFornecedorDTO.class); //tipo da resposta d aminha requisição
		
		System.out.println(exchange.getBody().getEndereco());
		
		
		 eurekaClient.getInstances("fornecedor").stream().forEach(fornecedor -> {
		 
			 System.out.println("localhost: " + fornecedor.getPort()); });
		 /**/
		
		
		
	}
	
}
