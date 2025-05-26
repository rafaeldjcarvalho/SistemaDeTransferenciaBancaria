package com.rafael.SistemaDeTransferenciaBancaria.domain.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.SistemaDeTransferenciaBancaria.domain.dtos.TransactionDTO;
import com.rafael.SistemaDeTransferenciaBancaria.domain.repository.TransactionRepository;
import com.rafael.SistemaDeTransferenciaBancaria.domain.transaction.Transaction;
import com.rafael.SistemaDeTransferenciaBancaria.domain.user.User;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthorizationService authService;
	
	@Autowired
	private NotificationService notificationService;
	
	public Transaction createTransaction(TransactionDTO transacao) {
		User remetente = this.userService.findUserById(transacao.remetente());
		User destinatario = this.userService.findUserById(transacao.destinatario());
		
		userService.validTransaction(remetente, transacao.valor());
		
		boolean isAuthorized = this.authService.authorizeTransaction(destinatario, transacao.valor());
		
		if(!isAuthorized) {
			throw new RuntimeException("Transação não autorizada.");
		}
		
		Transaction novaTransacao = new Transaction();
		novaTransacao.setValor(transacao.valor());
		novaTransacao.setRemetente(remetente);
		novaTransacao.setDestinatário(destinatario);
		novaTransacao.setDataHora(LocalDateTime.now());
		
		remetente.setSaldo(remetente.getSaldo().subtract(transacao.valor()));
		destinatario.setSaldo(destinatario.getSaldo().add(transacao.valor()));
		
		this.transactionRepository.save(novaTransacao);
		this.userService.saveUser(remetente);
		this.userService.saveUser(destinatario);
		
		this.notificationService.sendNotification(remetente, "Transação realizada");
		this.notificationService.sendNotification(destinatario, "Transação realizada");
		
		return novaTransacao;
	}

}
