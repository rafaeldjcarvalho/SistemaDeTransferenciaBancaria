package com.rafael.SistemaDeTransferenciaBancaria.domain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.SistemaDeTransferenciaBancaria.domain.dtos.TransactionDTO;
import com.rafael.SistemaDeTransferenciaBancaria.domain.services.TransactionService;
import com.rafael.SistemaDeTransferenciaBancaria.domain.transaction.Transaction;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping
	public ResponseEntity<Transaction> createTransaction(TransactionDTO transacao) {
		Transaction novaTransacao = this.transactionService.createTransaction(transacao);
		return new ResponseEntity<>(novaTransacao, HttpStatus.OK);
	}
}
