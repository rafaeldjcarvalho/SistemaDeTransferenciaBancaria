package com.rafael.SistemaDeTransferenciaBancaria.domain.user;


import java.math.BigDecimal;

import com.rafael.SistemaDeTransferenciaBancaria.domain.enums.UserType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String sobrenome;
	
	@Column(unique = true)
	private String documento; // CPF or CNPJ
	
	@Column(unique = true)
	private String email;
	
	private String senha;
	
	private BigDecimal saldo;
	
	private UserType tipo;

}
