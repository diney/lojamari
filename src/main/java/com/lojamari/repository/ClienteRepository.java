package com.lojamari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojamari.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer > {

}
