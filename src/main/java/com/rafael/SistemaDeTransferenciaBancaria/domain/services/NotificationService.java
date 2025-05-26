package com.rafael.SistemaDeTransferenciaBancaria.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rafael.SistemaDeTransferenciaBancaria.domain.dtos.NotificationDTO;
import com.rafael.SistemaDeTransferenciaBancaria.domain.user.User;

@Service
public class NotificationService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public void sendNotification(User usuario, String message) {
		String email = usuario.getEmail();
		
		NotificationDTO notificationRequest = new NotificationDTO(email, message);
		
		//ResponseEntity<String> notificationResponse = restTemplate.postForEntity("http://o4d9z.mocklab.io/notify", notificationRequest, String.class);

        //if(!(notificationResponse.getStatusCode() == HttpStatus.OK)){
            //System.out.println("erro ao enviar notificacao");
        //throw new Exception("Serviço de notificação está fora do ar");
        //}

        System.out.println("Notificacao enviada para o usuario");
	}

}
