package com.tcc.signer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcc.signer.domain.StatusPagamento;
import com.tcc.signer.domain.StatusPedido;
import com.tcc.signer.domain.Usuario;
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
		
		
		statusPagamentoRepository.save(spa1);
		statusPagamentoRepository.save(spa2);
		statusPedidoRepository.save(sp1);
		statusPedidoRepository.save(sp2);
		usuarioRepository.save(user1);
		usuarioRepository.save(user2);
		
	}
}
