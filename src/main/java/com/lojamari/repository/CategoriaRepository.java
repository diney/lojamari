package com.lojamari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojamari.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer > {

}
