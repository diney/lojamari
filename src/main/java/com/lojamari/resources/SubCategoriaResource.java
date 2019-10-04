package com.lojamari.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lojamari.domain.SubCategoria;
import com.lojamari.services.SubCategoriaService;

@RestController
@RequestMapping(value="/subCategorias")
public class SubCategoriaResource {

	

	@Autowired
	private SubCategoriaService service;
	
	
	@RequestMapping(value ="/{id}",method=RequestMethod.GET)
	public ResponseEntity<SubCategoria> find(@PathVariable Integer id) {		
		SubCategoria obj = service.find(id);
		return ResponseEntity.ok().body(obj);			
	}
}
