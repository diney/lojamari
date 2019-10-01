package com.lojamari.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojamari.domain.Pedido;
import com.lojamari.repository.PedidoRepository;
import com.lojamari.services.exceptions.ObjectNotFoundException;

@Service
public class SubCategoriaService {
	@Autowired
	private PedidoRepository repo;	

	

}
