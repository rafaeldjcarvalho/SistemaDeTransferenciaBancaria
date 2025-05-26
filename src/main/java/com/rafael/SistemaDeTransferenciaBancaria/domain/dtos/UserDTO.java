package com.rafael.SistemaDeTransferenciaBancaria.domain.dtos;

import java.math.BigDecimal;

import com.rafael.SistemaDeTransferenciaBancaria.domain.enums.UserType;

public record UserDTO(
		Long id,
		String nome,
		String sobrenome,
		String documento,
		String email,
		String senha,
		UserType tipo,
		BigDecimal saldo) {}
