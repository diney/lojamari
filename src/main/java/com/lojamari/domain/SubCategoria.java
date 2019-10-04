package com.lojamari.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SubCategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "SUBCATEGORIA_CATEGORIA",
			joinColumns = @JoinColumn(name = "sucategoria_id"),
			inverseJoinColumns = @JoinColumn(name = "categoria_id")
	)
	private List<Categoria> categorias  = new ArrayList<>();
	
	
	
	
	@ManyToMany(mappedBy ="subCategorias")
	private List<Produto> produtos = new ArrayList<>();
	

	
	
	public SubCategoria() {
		
	}	
	

	public SubCategoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}


	public List<Categoria> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	
}
