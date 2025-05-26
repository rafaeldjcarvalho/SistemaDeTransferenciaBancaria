package com.rafael.SistemaDeTransferenciaBancaria.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.SistemaDeTransferenciaBancaria.domain.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findUserByDocumento(String documento);
	Optional<User> findUserById(Long id);
}
