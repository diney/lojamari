package com.lojamari.services;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojamari.domain.ItemPedido;
import com.lojamari.domain.PagamentoComBoleto;
import com.lojamari.domain.PagamentoComCartao;
import com.lojamari.domain.PagamentoComDinheiro;
import com.lojamari.domain.Pedido;
import com.lojamari.domain.enums.EstadoPagamento;
import com.lojamari.repository.ItemPedidoRepository;
import com.lojamari.repository.PagamentoRepository;
import com.lojamari.repository.PedidoRepository;
import com.lojamari.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repo;

	@Autowired
	private BoletoService boletoService;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ClienteService clienteService;
	
	
	

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
   @Transactional
   public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
	 obj.setCliente(clienteService.find(obj.getCliente().getId()));
		obj.getPagamento().setEstado(EstadoPagamento.QUITADO);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		if (obj.getPagamento() instanceof PagamentoComDinheiro) {
			PagamentoComDinheiro pagto = (PagamentoComDinheiro) obj.getPagamento();
			boletoService.dataPagamentoComDinheiro(pagto, obj.getInstante());
			
		}
		if (obj.getPagamento() instanceof PagamentoComCartao) {
			PagamentoComCartao pagto = (PagamentoComCartao) obj.getPagamento();
			boletoService.dataPagamentoComCartao(pagto, obj.getInstante());
			
		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemPedido ip : obj.getItens()) {		
			ip.setProduto(produtoService.find(ip.getProduto().getId()));
			produtoService.update(ip.getProduto().getId());
			ip.setPreco(ip.getProduto().getPrecoVenda());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		System.out.println(obj.getItens());
		 
		return obj;

	}

}
