package com.rafael.SistemaDeTransferenciaBancaria.domain.services;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rafael.SistemaDeTransferenciaBancaria.domain.user.User;

@Service
public class AuthorizationService {
	
	//@Autowired
	//private RestTemplate restTemplate;
	
	//@Value("${app.authorizationApi}")
	//private String authApiUrl;
	
	public boolean authorizeTransaction(User usuario, BigDecimal valor) {
		//ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity(this.authApiUrl, Map.class);
		
		//if(authorizationResponse.getStatusCode() == HttpStatus.OK) {
		//	String mensagem = (String) authorizationResponse.getBody().get("message");
		//	return "Autorizado".equals(mensagem);
		//} else return false;
		return true;
	}

}
