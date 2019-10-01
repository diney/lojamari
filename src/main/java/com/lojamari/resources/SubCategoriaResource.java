package com.lojamari.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojamari.services.SubCategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class SubCategoriaResource {

	

	@Autowired
	private SubCategoriaService service;
}
