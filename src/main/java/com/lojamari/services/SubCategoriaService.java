package com.lojamari.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojamari.domain.SubCategoria;
import com.lojamari.repository.SubCategoriaRepository;
import com.lojamari.services.exceptions.ObjectNotFoundException;

@Service
public class SubCategoriaService {
	@Autowired
	private SubCategoriaRepository repo;
	
	
	public SubCategoria find(Integer id) {
		Optional<SubCategoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + SubCategoria.class.getName()));
	}	
	

	

}
