package com.lojamari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojamari.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer > {

}