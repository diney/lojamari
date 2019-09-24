package com.lojamari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojamari.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Integer > {

}
