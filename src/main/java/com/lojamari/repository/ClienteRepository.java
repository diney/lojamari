package com.lojamari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lojamari.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer > {
	
	@Transactional(readOnly = true)
	Cliente findByEmail(String email);
	
	@Transactional(readOnly = true)
	Cliente findByNome(String nome);
	
	

}
