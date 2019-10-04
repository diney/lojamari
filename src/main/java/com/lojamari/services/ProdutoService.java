package com.lojamari.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.lojamari.domain.Produto;
import com.lojamari.domain.SubCategoria;
import com.lojamari.repository.ProdutoRepository;
import com.lojamari.repository.SubCategoriaRepository;
import com.lojamari.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repo;
	
	/*
	 * @Autowired private CategoriaRepository categoriaRepository ;
	 */
	
	@Autowired
	private SubCategoriaRepository subCategoriaRepository ;	

	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public Page<Produto> search(String nome ,List<Integer> idsSub,Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<SubCategoria> subCategorias = subCategoriaRepository.findAllById(idsSub);
		//List<Categoria> categorias = categoriaRepository.findAllById(idsCat);
		return repo.search(nome,subCategorias, pageRequest);
		
		
		
	}

}
