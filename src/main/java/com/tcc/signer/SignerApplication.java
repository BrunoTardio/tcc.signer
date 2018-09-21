package com.tcc.signer;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcc.signer.domain.ItemPedido;
import com.tcc.signer.domain.Pagamento;
import com.tcc.signer.domain.PagamentoComCartao;
import com.tcc.signer.domain.Pedido;
import com.tcc.signer.domain.Produto;
import com.tcc.signer.domain.ProdutoDescricao;
import com.tcc.signer.domain.ProdutoTipo;
import com.tcc.signer.domain.ProdutoValidade;
import com.tcc.signer.domain.StatusPedido;
import com.tcc.signer.domain.Telefone;
import com.tcc.signer.domain.Usuario;
import com.tcc.signer.domain.UsuarioEmail;
import com.tcc.signer.domain.enums.EstadoPagamento;
import com.tcc.signer.domain.enums.TipoProduto;
import com.tcc.signer.repositories.ItemPedidoRepository;
import com.tcc.signer.repositories.PagamentoRepository;
import com.tcc.signer.repositories.PedidoRepository;
import com.tcc.signer.repositories.ProdutoDescricaoRepository;
import com.tcc.signer.repositories.ProdutoRepository;
import com.tcc.signer.repositories.ProdutoTipoRepository;
import com.tcc.signer.repositories.ProdutoValidadeRepository;
import com.tcc.signer.repositories.StatusPedidoRepository;
import com.tcc.signer.repositories.TelefoneRepository;
import com.tcc.signer.repositories.UsuarioEmailRepository;
import com.tcc.signer.repositories.UsuarioRepository;

@SpringBootApplication
public class SignerApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(SignerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}

