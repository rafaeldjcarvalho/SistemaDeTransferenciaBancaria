package com.rafael.SistemaDeTransferenciaBancaria.domain.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.SistemaDeTransferenciaBancaria.domain.dtos.UserDTO;
import com.rafael.SistemaDeTransferenciaBancaria.domain.services.UserService;
import com.rafael.SistemaDeTransferenciaBancaria.domain.user.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> lista = this.userService.listAll();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody UserDTO usuario) {
		User novoUsuario = this.userService.createUser(usuario);
		return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
	}
}
