package com.tcc.signer;



import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tcc.signer.domain.AlocacaoFuncionario;
import com.tcc.signer.domain.ItemPedido;
import com.tcc.signer.domain.Pagamento;
import com.tcc.signer.domain.PagamentoComCartao;
import com.tcc.signer.domain.Pedido;
import com.tcc.signer.domain.Produto;
import com.tcc.signer.domain.ProdutoDescricao;

import com.tcc.signer.domain.ProdutoTipo;
import com.tcc.signer.domain.ProdutoValidade;
import com.tcc.signer.domain.StatusNotificacao;
import com.tcc.signer.domain.StatusPagamento;
import com.tcc.signer.domain.StatusPedido;
import com.tcc.signer.domain.Telefone;
import com.tcc.signer.domain.Usuario;
import com.tcc.signer.domain.UsuarioEmail;
import com.tcc.signer.domain.enums.EstadoPagamento;
import com.tcc.signer.domain.enums.TipoProduto;
import com.tcc.signer.repositories.AlocacaoFuncionarioRepository;
import com.tcc.signer.repositories.ItemPedidoRepository;
import com.tcc.signer.repositories.PagamentoRepository;
import com.tcc.signer.repositories.PedidoRepository;
import com.tcc.signer.repositories.ProdutoDescricaoRepository;
import com.tcc.signer.repositories.ProdutoRepository;
import com.tcc.signer.repositories.ProdutoTipoRepository;
import com.tcc.signer.repositories.ProdutoValidadeRepository;
import com.tcc.signer.repositories.StatusNotificacaoRepository;
import com.tcc.signer.repositories.StatusPagamentoRepository;
import com.tcc.signer.repositories.StatusPedidoRepository;
import com.tcc.signer.repositories.TelefoneRepository;
import com.tcc.signer.repositories.UsuarioEmailRepository;
import com.tcc.signer.repositories.UsuarioRepository;


@SpringBootApplication
public class SignerApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private StatusPedidoRepository statusPedidoRepository;
	@Autowired
	private StatusPagamentoRepository statusPagamentoRepository;
	@Autowired
	private StatusNotificacaoRepository statusNotificacaoRepo;	
	@Autowired
	private ProdutoDescricaoRepository produtoDescricaoRepo;
	@Autowired
	private AlocacaoFuncionarioRepository alocacaoFuncionarioRepo;
	@Autowired
	private ProdutoRepository produtoRepo;
	@Autowired
	private ProdutoTipoRepository produtoTipoRepo;
	@Autowired
	private ProdutoValidadeRepository produtoValidadeRepo;
	@Autowired
	private TelefoneRepository telefoneRepo;
	@Autowired
	private UsuarioEmailRepository usuarioEmailRepo;
	@Autowired
	private PedidoRepository pedidoRepo;
	@Autowired
	private PagamentoRepository pagamentoRepo;
	@Autowired
	private ItemPedidoRepository itemPedidoRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SignerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	
		StatusPedido sp1 = new StatusPedido(null,"BOLETO");
		StatusPedido sp2 = new StatusPedido(null,"DCC");
		StatusPagamento spa1 = new StatusPagamento(null,"PAGOU");
		StatusPagamento spa2 = new StatusPagamento(null,"ABERTO");
		StatusNotificacao sn1 = new StatusNotificacao(null,"Em aberto");
		StatusNotificacao sn2 = new StatusNotificacao(null,"Fechado");
		AlocacaoFuncionario af1 = new AlocacaoFuncionario(null, "Operador");
		AlocacaoFuncionario af2 = new AlocacaoFuncionario(null, "Caixa");
	
		
		ProdutoDescricao pd1 = new ProdutoDescricao(null, "Midia Fisica");
		ProdutoDescricao pd2 = new ProdutoDescricao(null, "Midia Digital");
	
	
		
		alocacaoFuncionarioRepo.save(af1);
		alocacaoFuncionarioRepo.save(af2);
		produtoDescricaoRepo.save(pd1);
		produtoDescricaoRepo.save(pd2);
	
		statusNotificacaoRepo.save(sn2);
		statusNotificacaoRepo.save(sn1);
		statusPagamentoRepository.save(spa1);
		statusPagamentoRepository.save(spa2);
		statusPedidoRepository.save(sp1);
		statusPedidoRepository.save(sp2);
	
		
		// TESTANDO UM PARA MUITOS 000
		Usuario user1 = new Usuario(null, "tardio@","123");
		Usuario user2 = new Usuario(null, "xxxxx@","123");
		Telefone t1 = new Telefone(null,"329889992896","residencial",user1);
		UsuarioEmail ue1 = new UsuarioEmail(null, "Seu@seu", "Trabalho", user1);
		
		ProdutoValidade pv1 = new ProdutoValidade(null,"03 MESES");
		ProdutoTipo pt1 = new ProdutoTipo(null,"CPF");
		ProdutoTipo pt2 = new ProdutoTipo(null,"CNPJ");
		
		produtoTipoRepo.saveAll(Arrays.asList(pt1,pt2));
		produtoValidadeRepo.saveAll(Arrays.asList(pv1));
		
		
		Produto p1 = new Produto(null,"ACC - AA PF", 50.00 , pd1,pt1,pv1,TipoProduto.PESSOAFISICA);
		Produto p2 = new Produto(null,"ACC - AA JF", 50.00 , pd1,pt1,null,TipoProduto.PESSOAFISICA);
		Produto p3 = new Produto(null,"ACC - AA JF", 50.00 , pd2,pt2,null,TipoProduto.PESSOAFISICA);
		
		pd1.getProdutos().addAll(Arrays.asList(p1,p2));
		pd2.getProdutos().addAll(Arrays.asList(p2));
		pt1.getProdutos().addAll(Arrays.asList(p1,p2));
		pt1.getProdutos().addAll(Arrays.asList(p3));
		pv1.getProdutos().addAll(Arrays.asList(p1));
		user1.getTelefones().addAll(Arrays.asList(t1));
		user1.getUsuarioEmails().addAll(Arrays.asList(ue1));
	
		produtoRepo.saveAll(Arrays.asList(p1,p2,p3));
		usuarioRepository.save(user1);
		usuarioRepository.save(user2);
		telefoneRepo.saveAll(Arrays.asList(t1));
		usuarioEmailRepo.saveAll(Arrays.asList(ue1));
		
		// TESTANDO UM PARA UM
		
		SimpleDateFormat stf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, stf.parse("30/09/2017 10:32"), null,null,null,null);
		Pagamento pagto1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO, 
				ped1, 6);
		ped1.setPagamento(pagto1);
		// associar pessoa ao pedido depois
		// Items de pedido 
		
		pedidoRepo.saveAll(Arrays.asList(ped1));
		pagamentoRepo.saveAll(Arrays.asList(pagto1));
		
		ItemPedido ip1 = new ItemPedido(ped1,p1,0.00,1,2000.0);
		ItemPedido ip2 = new ItemPedido(ped1,p3,0.00,2,80.0);
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip1));
		itemPedidoRepo.saveAll(Arrays.asList(ip1,ip2));
	}
}
