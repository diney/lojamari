package com.lojamari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojamari.domain.SubCategoria;

@Repository
public interface SubCategoriaRepository extends JpaRepository<SubCategoria,Integer > {

}
