package com.lojamari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojamari.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Integer > {

}
