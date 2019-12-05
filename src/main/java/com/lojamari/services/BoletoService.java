package com.lojamari.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.lojamari.domain.PagamentoComBoleto;
import com.lojamari.domain.PagamentoComCartao;
import com.lojamari.domain.PagamentoComDinheiro;

@Service
public class BoletoService {
	
	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 30);
		pagto.setDataVencimento(cal.getTime());
		pagto.setDataPagamento(instanteDoPedido);
	}
	
	public void dataPagamentoComDinheiro(PagamentoComDinheiro pagto, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);		
		pagto.setDataPagamento(instanteDoPedido);
	}
	
	public void dataPagamentoComCartao(PagamentoComCartao pagto, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);		
		pagto.setDataPagamento(instanteDoPedido);
	}


}
