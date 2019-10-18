package com.lojamari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lojamari.domain.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer > {
	
	
	@Transactional(readOnly = true)
	Admin findByNome(String nome);
}
