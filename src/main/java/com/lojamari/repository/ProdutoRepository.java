package com.lojamari.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.lojamari.domain.Produto;
import com.lojamari.domain.SubCategoria;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer > {
	
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.subCategorias subCat   WHERE obj.nome LIKE %:nome% AND subCat IN :subCategorias   ")
	Page<Produto> search(@Param("nome") String nome, @Param("subCategorias") List<SubCategoria> subCategorias, Pageable pageRequest);
	
	
	//Page<Produto> findDistinctByNomeContainingAndSubCategoriasIn(@Param("nome") String nome, @Param("subCategorias") List<SubCategoria> subCategorias, Pageable pageRequest);
	}


