package com.lojamari;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lojamari.domain.Categoria;
import com.lojamari.domain.Produto;
import com.lojamari.repository.CategoriaRepository;
import com.lojamari.repository.ProdutoRepository;

@SpringBootApplication
public class LojamariApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(LojamariApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Vestidos");
		Categoria cat2 = new Categoria(null, "Blusas");

		Produto p1 = new Produto(null, "Vestido com estampa", 150.00);
		Produto p2 = new Produto(null, "Blusa com estampa", 100.00);
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat2));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2));

	}

}
