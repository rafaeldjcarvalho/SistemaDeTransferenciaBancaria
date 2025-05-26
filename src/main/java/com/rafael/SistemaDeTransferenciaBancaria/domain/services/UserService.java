package com.rafael.SistemaDeTransferenciaBancaria.domain.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.SistemaDeTransferenciaBancaria.domain.dtos.UserDTO;
import com.rafael.SistemaDeTransferenciaBancaria.domain.enums.UserType;
import com.rafael.SistemaDeTransferenciaBancaria.domain.repository.UserRepository;
import com.rafael.SistemaDeTransferenciaBancaria.domain.user.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void validTransaction(User remetente, BigDecimal valor) {
		if(remetente.getTipo() == UserType.LOJISTA) {
			throw new RuntimeException("Usuário LOJISTA não faz transferência.");
		}
		
		if(remetente.getSaldo().compareTo(valor) < 0) {
			throw new RuntimeException("O usuário não possui saldo suficiente.");
		}
	}
	
	public User createUser(UserDTO dados) {
		User novoUsuario = new User(dados);
		this.saveUser(novoUsuario);
		return novoUsuario;
	}
	
	public List<User> listAll() {
		return this.userRepository.findAll();
	}
	
	public User findUserById(Long id) {
		return this.userRepository.findUserById(id).orElseThrow(() -> new RuntimeException("Usuário não encntrado"));
	}
	
	public void saveUser(User usuario) {
		this.userRepository.save(usuario);
	}

}
