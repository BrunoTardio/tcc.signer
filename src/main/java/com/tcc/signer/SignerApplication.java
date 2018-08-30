package com.tcc.signer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcc.signer.domain.AlocacaoFuncionario;
import com.tcc.signer.domain.ProdutoDescricao;
import com.tcc.signer.domain.StatusNotificacao;
import com.tcc.signer.domain.StatusPagamento;
import com.tcc.signer.domain.StatusPedido;
import com.tcc.signer.domain.Usuario;
import com.tcc.signer.repositories.AlocacaoFuncionarioRepository;
import com.tcc.signer.repositories.ProdutoDescricaoRepository;
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
		
	}
}
