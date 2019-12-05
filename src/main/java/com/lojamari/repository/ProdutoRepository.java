package com.lojamari.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lojamari.domain.Categoria;
import com.lojamari.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer > {
	
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat   WHERE obj.nome LIKE %:nome% AND cat IN :categorias   ")
	Page<Produto> search(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);
	
	@Query("SELECT DISTINCT obj FROM Produto obj  WHERE obj.id =?1 and situacao = 1   ")
	Optional<Produto>  findBySituacaoTrue(Integer id);
	
	
	@Query("SELECT COUNT (DISTINCT id) FROM Produto obj  WHERE  obj.situacao = 1")
	long  count();
	
	}


