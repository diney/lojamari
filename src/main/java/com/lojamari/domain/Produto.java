package com.lojamari.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double preco;
	private String fornecedor;
	private String cor;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "PRODUTO_SUBCATEGORIA",
			joinColumns = @JoinColumn(name = "produto_id"),
			inverseJoinColumns = @JoinColumn(name = "subCategoria_id")
	)
	private List<SubCategoria> subCategorias  = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.produto")
	private Set<ItemPedido> itens = new HashSet<>();
	
	public Produto() {
		
	}
	
	public Produto(Integer id, String nome, Double preco,String fornecedor,String cor) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.fornecedor = fornecedor;
		this.cor = cor;
	}
	
	@JsonIgnore
	public List<Pedido> getPedidos(){
		List<Pedido> lista = new ArrayList<>();
		for(ItemPedido x : itens) {
			lista.add(x.getPedido());
						
		}
		return lista;
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


	public List<SubCategoria> getSubCategorias() {
		return subCategorias;
	}


	public void setSubCategorias(List<SubCategoria> subCategorias) {
		this.subCategorias = subCategorias;
	}


	public Set<ItemPedido> getItens() {
		return itens;
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

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
