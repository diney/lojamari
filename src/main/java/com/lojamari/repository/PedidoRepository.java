package com.lojamari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojamari.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer > {

}
