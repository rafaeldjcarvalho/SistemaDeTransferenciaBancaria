package com.rafael.SistemaDeTransferenciaBancaria.domain.user;


import java.math.BigDecimal;

import com.rafael.SistemaDeTransferenciaBancaria.domain.dtos.UserDTO;
import com.rafael.SistemaDeTransferenciaBancaria.domain.enums.UserType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
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
	
	@Enumerated(EnumType.STRING)
	private UserType tipo;
	
	public User(UserDTO dados) {
		setNome(dados.nome());
		setSobrenome(dados.sobrenome());
		setDocumento(dados.documento());
		setEmail(dados.email());
		setSenha(dados.senha());
		setSaldo(dados.saldo());
		setTipo(dados.tipo());
	}

}
