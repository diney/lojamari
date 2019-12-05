package com.lojamari.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lojamari.domain.Admin;
import com.lojamari.domain.Categoria;
import com.lojamari.domain.Cidade;
import com.lojamari.domain.Cliente;
import com.lojamari.domain.Endereco;
import com.lojamari.domain.Estado;
import com.lojamari.domain.ItemPedido;
import com.lojamari.domain.Pagamento;
import com.lojamari.domain.PagamentoComCartao;
import com.lojamari.domain.Pedido;
import com.lojamari.domain.Produto;
import com.lojamari.domain.enums.EstadoPagamento;
import com.lojamari.repository.AdminRepository;
import com.lojamari.repository.CategoriaRepository;
import com.lojamari.repository.CidadeRepository;
import com.lojamari.repository.ClienteRepository;
import com.lojamari.repository.EnderecoRepository;
import com.lojamari.repository.EstadoRepository;
import com.lojamari.repository.ItemPedidoRepository;
import com.lojamari.repository.PagamentoRepository;
import com.lojamari.repository.PedidoRepository;
import com.lojamari.repository.ProdutoRepository;
@Service
public class DBService {
	

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;	

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public void instantiateTestDatabase() throws ParseException {

		// Categorias criadas
		Categoria cat1 = new Categoria(null, "Vestidos");
		Categoria cat2 = new Categoria(null, "Blusas");
		Categoria cat3 = new Categoria(null, "Saias");
		Categoria cat4 = new Categoria(null, "Meias");
		Categoria cat5 = new Categoria(null, "Cuecas");
		Categoria cat6 = new Categoria(null, "Biquine");

		// Produtos criadas
		Produto p1 = new Produto(null, "Vestido com estampa", 10.00, 100.00, null, null, null, false);
		Produto p2 = new Produto(null, "Blusa com estampa", 10.00, 100.00, null, null, null, false);
		Produto p3 = new Produto(null, "Saia Linho Estampada", 10.00, 170.00, null, null, null, false);
		Produto p4 = new Produto(null, "Blusas Floral  Decote Largo Manga Curta", 10.00, 70.00, null, null, null, false);

		// Categoria recebe subCategoria
		cat1.getProdutos().addAll(Arrays.asList(p1));

		cat3.getProdutos().addAll(Arrays.asList(p3));
		cat2.getProdutos().addAll(Arrays.asList(p4));

		
		 
		 //Produto recebe Categoria
		 p1.getCategorias().addAll(Arrays.asList(cat1));
		 p2.getCategorias().addAll(Arrays.asList(cat2));
		 p3.getCategorias().addAll(Arrays.asList(cat3));
		 p4.getCategorias().addAll(Arrays.asList(cat2));
		 
		 

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6));

		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

		Estado est1 = new Estado(null, "Santa Catarina");
		Cidade c1 = new Cidade(null, "Florianópolis", est1);

		est1.getCidades().addAll(Arrays.asList(c1));

		estadoRepository.saveAll(Arrays.asList(est1));
		cidadeRepository.saveAll(Arrays.asList(c1));
       
		Admin admin = new Admin(null,"mari", pe.encode("1234"));
		Admin admin2 = new Admin(null,"diney", pe.encode("qwer"));
		
		
		adminRepository.saveAll(Arrays.asList(admin,admin2));
		
		Cliente cli1 = new Cliente(null, "Diney", "diney.dom@gmail.com", "123456789");
		

		Endereco e1 = new Endereco(null, "Joaquin Neves", "300", "", "Pântano do Sul ", "88067120", cli1, c1);

		

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("25/09/2019 13:35"), cli1);

		Pagamento pagt1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6, null);
		ped1.setPagamento(pagt1);

		cli1.getPedidos().addAll(Arrays.asList(ped1));

		pedidoRepository.saveAll(Arrays.asList(ped1));
		pagamentoRepository.saveAll(Arrays.asList(pagt1));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, p1.getPrecoVenda());
		ItemPedido ip2 = new ItemPedido(ped1, p2, 10.00, 3, p2.getPrecoVenda());
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));

		p1.getItens().addAll(Arrays.asList(ip1, ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2));

	}


}
