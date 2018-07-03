package com.gohan.button.worker;

import java.util.Collections;

import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

 
 @Configuration
public class WebServiceConfig {
    
	@Value("${cxf.jaxrs.client.address}")
	private String urlMicroservices;
	
    @Bean(name = "webClient")
	public WebClient createWebClient() {
		WebClient webClient = WebClient.create(urlMicroservices, Collections.singletonList(new JacksonJsonProvider()));
		System.out.println("Configurando microservicios");
		return webClient;
	}
}