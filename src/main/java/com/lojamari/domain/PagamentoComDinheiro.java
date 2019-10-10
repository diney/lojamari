package com.lojamari.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.lojamari.domain.enums.EstadoPagamento;
@Entity
@JsonTypeName("pagamentoComDinheiro")
public class PagamentoComDinheiro extends Pagamento{
	private static final long serialVersionUID = 1L;	
	
	private Date dataPagamento;
	
	public  PagamentoComDinheiro() {
		
	}

	public PagamentoComDinheiro(Integer id, EstadoPagamento estado, Pedido pedido,Date dataPagamento) {
		super(id, estado, pedido);
	
		this.dataPagamento = dataPagamento;		
	}	

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	

}
