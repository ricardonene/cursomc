package br.com.ricardonene.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ricardonene.cursomc.domain.Categoria;
import br.com.ricardonene.cursomc.domain.Cidade;
import br.com.ricardonene.cursomc.domain.Cliente;
import br.com.ricardonene.cursomc.domain.Endereco;
import br.com.ricardonene.cursomc.domain.Estado;
import br.com.ricardonene.cursomc.domain.ItemPedido;
import br.com.ricardonene.cursomc.domain.PagamentoComBoleto;
import br.com.ricardonene.cursomc.domain.PagamentoComCartao;
import br.com.ricardonene.cursomc.domain.Pedido;
import br.com.ricardonene.cursomc.domain.Produto;
import br.com.ricardonene.cursomc.domain.enums.EstadoPagamento;
import br.com.ricardonene.cursomc.domain.enums.TipoCliente;
import br.com.ricardonene.cursomc.repositories.CategoriaRepository;
import br.com.ricardonene.cursomc.repositories.CidadeRepository;
import br.com.ricardonene.cursomc.repositories.ClienteRepository;
import br.com.ricardonene.cursomc.repositories.EnderecoRepository;
import br.com.ricardonene.cursomc.repositories.EstadoRepository;
import br.com.ricardonene.cursomc.repositories.ItemPedidoRepository;
import br.com.ricardonene.cursomc.repositories.PagamentoRepository;
import br.com.ricardonene.cursomc.repositories.PedidoRepository;
import br.com.ricardonene.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Compressor de Ar");
		Categoria cat4 = new Categoria(null, "Ferramentas Automotivas");
		Categoria cat5 = new Categoria(null, "Ferramentas Diversas");
		Categoria cat6 = new Categoria(null, "Ferramentas Dremel");
		Categoria cat7 = new Categoria(null, "Ferramentas para Jardim");
		Categoria cat8 = new Categoria(null, "Ferramentas Pneumáticas");
		Categoria cat9 = new Categoria(null, "Geradores de Energia");
		Categoria cat10 = new Categoria(null, "Hidráulica");
		Categoria cat11 = new Categoria(null, "Instrumentos de Medição");
		Categoria cat12 = new Categoria(null, "Manutenção de Máquinas");
		Categoria cat13 = new Categoria(null, "Máquina de Costura");
		Categoria cat14 = new Categoria(null, "Maquinas de Embalar");
		Categoria cat15 = new Categoria(null, "Máquinas de Solda");
		Categoria cat16 = new Categoria(null, "Máquinas e Equipamentos");
		Categoria cat17 = new Categoria(null, "Máquinas Industriais");
		Categoria cat18 = new Categoria(null, "Máquinas para Madeira");
		Categoria cat19 = new Categoria(null, "Movimentação de Cargas");
		Categoria cat20 = new Categoria(null, "Outras Máquinas");
		Categoria cat21 = new Categoria(null, "Parafusos e Fixadores");
		Categoria cat22 = new Categoria(null, "Peças para Máquinas");
		Categoria cat23 = new Categoria(null, "Rolamentos e Motores");
		Categoria cat24 = new Categoria(null, "Talhas e Guinchos");

		Produto p1 = new Produto(null, "Computador", 2000.0);
		Produto p2 = new Produto(null, "Impressora", 800.0);
		Produto p3 = new Produto(null, "Mouse", 80.0);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10, cat11,
				cat12, cat13, cat14, cat15, cat16, cat17, cat18, cat19, cat20, cat21, cat22, cat23, cat24));

		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("2736323", "93898993"));

		Endereco e1 = new Endereco(null, "Rua Flores", "11", "111", "Centro", "97670-999", cli1, c1);
		Endereco e2 = new Endereco(null, "Av Matos", "11", "111", "Centro", "97670-999", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.save(cli1);
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

		PagamentoComCartao pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pgto1);

		PagamentoComBoleto pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2,
				sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pgto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pgto1, pgto2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

	}

}
