package com.lojamari.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.lojamari.domain.Categoria;
import com.lojamari.domain.Produto;
import com.lojamari.repository.CategoriaRepository;
import com.lojamari.repository.ProdutoRepository;
import com.lojamari.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repo;
	
	
	 @Autowired
	 private CategoriaRepository categoriaRepository ;
	
	
	

	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"O produto " + id + " não foi encontrado!  "  ));
	}
	
	public Produto findSituacao(Integer id) {
		Optional<Produto> obj = repo.findBySituacaoTrue(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"O produto " + id + " não foi encontrado!  "  ));
	}
	
	public Produto update(Integer obj) {		
		Produto newObj = find(obj);
		updateData(newObj);
		return repo.save(newObj);
	}
	
	public Page<Produto> search(String nome ,List<Integer> idsCat,Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(idsCat);
		//List<Categoria> categorias = categoriaRepository.findAllById(idsCat);
		return repo.search(nome,categorias, pageRequest);
		
		
		
	}
	
	 @Transactional
	   public Produto insert(Produto obj) {
			obj.setId(null);
			obj.setSituacao(true);
			obj = repo.save(obj);			 
			return obj;

		}
	 
	 public List<Produto> findAll(){
			return repo.findAll();
		}
	 
	
	private void updateData(Produto newObj) {
			newObj.setSituacao(false);
			
			
		}
	
	 public long cuontProd(){
			return repo.count();
		}
	 


}
