package com.lojamari.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.lojamari.domain.PagamentoComBoleto;

@Service
public class BoletoService {
	
	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 30);
		pagto.setDataVencimento(cal.getTime());
	}

}
