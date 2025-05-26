package com.rafael.SistemaDeTransferenciaBancaria.domain.dtos;

import java.math.BigDecimal;

public record TransactionDTO(
		BigDecimal valor,
		Long remetente,
		Long destinatario) {}
