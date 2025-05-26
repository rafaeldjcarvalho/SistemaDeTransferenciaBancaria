package com.rafael.SistemaDeTransferenciaBancaria.domain.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.rafael.SistemaDeTransferenciaBancaria.domain.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "sender_id")
	private User remetente;
	
	@ManyToOne
	@JoinColumn(name = "reciver_id")
	private User destinatário;
	
	private LocalDateTime dataHora;
}
