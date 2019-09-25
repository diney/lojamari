package com.lojamari;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lojamari.domain.Categoria;
import com.lojamari.domain.Cidade;
import com.lojamari.domain.Cliente;
import com.lojamari.domain.Endereco;
import com.lojamari.domain.Estado;
import com.lojamari.domain.Pagamento;
import com.lojamari.domain.PagamentoComCartao;
import com.lojamari.domain.Pedido;
import com.lojamari.domain.Produto;
import com.lojamari.domain.SubCategoria;
import com.lojamari.domain.enums.EstadoPagamento;
import com.lojamari.domain.enums.TipoCliente;
import com.lojamari.repository.CategoriaRepository;
import com.lojamari.repository.CidadeRepository;
import com.lojamari.repository.ClienteRepository;
import com.lojamari.repository.EnderecoRepository;
import com.lojamari.repository.EstadoRepository;
import com.lojamari.repository.PagamentoRepository;
import com.lojamari.repository.PedidoRepository;
import com.lojamari.repository.ProdutoRepository;
import com.lojamari.repository.SubCategoriaRepository;

@SpringBootApplication
public class LojamariApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private SubCategoriaRepository subCategoriaRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository  pagamentoRepository;


	public static void main(String[] args) {
		SpringApplication.run(LojamariApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Categorias criadas
		Categoria cat1 = new Categoria(null, "Vestidos");		
		Categoria cat2 = new Categoria(null, "Blusas");		
		Categoria cat3 = new Categoria(null, "Saias");
		
		//Subcategorias criadas
		SubCategoria subCat1 = new SubCategoria(null,"Vestido com estampa");
		SubCategoria subCat2 = new SubCategoria(null, "Vestido ");
		SubCategoria subCat3 = new SubCategoria(null, "Saia Linho Estampada ");
		SubCategoria subCat4 = new SubCategoria(null, "Blusas Floral  ");
		
		//Produtos  criadas
		Produto p1 = new Produto(null, "Vestido com estampa", 150.00);
		Produto p2 = new Produto(null, "Blusa com estampa", 100.00);
		Produto p3 = new Produto(null, "Saia Linho Estampada", 170.00);
		Produto p4 = new Produto(null, "Blusas Floral  Decote Largo Manga Curta", 70.00);
		
		//Categoria recebe subCategoria
		cat1.getSubCategorias().addAll(Arrays.asList(subCat1 ));
		cat1.getSubCategorias().addAll(Arrays.asList(subCat2 ));		
		cat3.getSubCategorias().addAll(Arrays.asList(subCat3 ));
		cat2.getSubCategorias().addAll(Arrays.asList(subCat4 ));
		
		//SubCategoria vê a sua categoria
		subCat1.getSubCategorias().addAll(Arrays.asList(cat1));
		subCat2.getSubCategorias().addAll(Arrays.asList(cat1));		
		subCat3.getSubCategorias().addAll(Arrays.asList(cat3));
		
		//Produto recebe subCategoria
		p1.getSubCategorias().addAll(Arrays.asList(subCat1));
		p2.getSubCategorias().addAll(Arrays.asList(subCat4));
		p3.getSubCategorias().addAll(Arrays.asList(subCat3));
		p4.getSubCategorias().addAll(Arrays.asList(subCat4));
			
		

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2,cat3));
		subCategoriaRepository.saveAll(Arrays.asList(subCat1, subCat2, subCat3, subCat4));
		produtoRepository.saveAll(Arrays.asList(p1, p2,p3,p4));
		
		
		
		Estado est1 = new Estado (null, "Santa Catarina" );		
		Cidade c1 = new Cidade(null, "Florianópolis",est1);
		
		
		est1.getCidades().addAll(Arrays.asList(c1));
		
		estadoRepository.saveAll(Arrays.asList(est1));
		cidadeRepository.saveAll(Arrays.asList(c1));
		
		
		Cliente cli1 = new Cliente(null,"Diney","diney@gmail.com","123456789",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("12345678","09876542"));
		
		Endereco e1  = new Endereco(null,"Joaquin Neves","300","","Pântano do Sul ","88067120",cli1,c1);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("25/09/2019 13:35"), cli1);
		
		Pagamento pagt1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagt1);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1));
		
		pedidoRepository.saveAll(Arrays.asList(ped1));
		pagamentoRepository.saveAll(Arrays.asList(pagt1));

	}

}
