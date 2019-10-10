package com.lojamari.dto;

import java.io.Serializable;

import com.lojamari.domain.Produto;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private Double preco;
	private String fornecedor;
	private String cor;

	public ProdutoDTO() {

	}

	public ProdutoDTO(Produto obj) {
		
		id = obj.getId();
		nome = obj.getNome();
		preco  = obj.getPrecoVenda();
		cor = obj.getCor();
		fornecedor = obj.getFornecedor();
		

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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}
