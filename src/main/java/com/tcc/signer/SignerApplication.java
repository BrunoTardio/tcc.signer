package com.tcc.signer;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcc.signer.domain.AlocacaoFuncionario;
import com.tcc.signer.domain.Produto;
import com.tcc.signer.domain.ProdutoDescricao;
import com.tcc.signer.domain.StatusNotificacao;
import com.tcc.signer.domain.StatusPagamento;
import com.tcc.signer.domain.StatusPedido;
import com.tcc.signer.domain.Usuario;
import com.tcc.signer.repositories.AlocacaoFuncionarioRepository;
import com.tcc.signer.repositories.ProdutoDescricaoRepository;
import com.tcc.signer.repositories.ProdutoRepository;
import com.tcc.signer.repositories.StatusNotificacaoRepository;
import com.tcc.signer.repositories.StatusPagamentoRepository;
import com.tcc.signer.repositories.StatusPedidoRepository;
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
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SignerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Usuario user1 = new Usuario(null, "tardio@","123");
		Usuario user2 = new Usuario(null, "xxxxx@","123");
		StatusPedido sp1 = new StatusPedido(null,"BOLETO");
		StatusPedido sp2 = new StatusPedido(null,"DCC");
		StatusPagamento spa1 = new StatusPagamento(null,"PAGOU");
		StatusPagamento spa2 = new StatusPagamento(null,"ABERTO");
		StatusNotificacao sn1 = new StatusNotificacao(null,"Em aberto");
		StatusNotificacao sn2 = new StatusNotificacao(null,"Fechado");
		ProdutoDescricao pd1 = new ProdutoDescricao(null, "Midia Fisica");
		ProdutoDescricao pd2 = new ProdutoDescricao(null, "Midia Digital");
		AlocacaoFuncionario af1 = new AlocacaoFuncionario(null, "Operador");
		AlocacaoFuncionario af2 = new AlocacaoFuncionario(null, "Caixa");
		
		Produto p1 = new Produto(null,"A3 - CPF ", 200.50);
		Produto p2 = new Produto(null,"A2 - CPF ", 150.50);
		Produto p3 = new Produto(null,"A1 - CNPJ ", 50.50);
		
		pd1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		pd2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getProdutoDescricoes().addAll(Arrays.asList(pd1));
		p2.getProdutoDescricoes().addAll(Arrays.asList(pd1,pd2));
		p3.getProdutoDescricoes().addAll(Arrays.asList(pd1));
		
		
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
		usuarioRepository.save(user1);
		usuarioRepository.save(user2);
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
	}
}
