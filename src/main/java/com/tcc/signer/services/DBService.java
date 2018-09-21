package com.tcc.signer.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class DBService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private StatusPedidoRepository statusPedidoRepository;

	@Autowired
	private ProdutoDescricaoRepository produtoDescricaoRepo;
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

	public void instantiateTestDatabase() throws ParseException {



		StatusPedido sp1 = new StatusPedido(null, "BOLETO");
		StatusPedido sp2 = new StatusPedido(null, "DCC");

		ProdutoDescricao pd1 = new ProdutoDescricao(null, "Midia Fisica");
		ProdutoDescricao pd2 = new ProdutoDescricao(null, "Midia Digital");
		ProdutoDescricao pd3 = new ProdutoDescricao(null, "Cama mesa banho");
		ProdutoDescricao pd4 = new ProdutoDescricao(null, "mortal");
		ProdutoDescricao pd5 = new ProdutoDescricao(null, "testando cat");
		ProdutoDescricao pd6 = new ProdutoDescricao(null, "Midia Butra");
		ProdutoDescricao pd7 = new ProdutoDescricao(null, "Gustaviz chur");
		ProdutoDescricao pd8 = new ProdutoDescricao(null, "emorroids");

		produtoDescricaoRepo.saveAll(Arrays.asList(pd1, pd2, pd3, pd4, pd5, pd6, pd7, pd8));

		statusPedidoRepository.save(sp1);
		statusPedidoRepository.save(sp2);

		// TESTANDO UM PARA MUITOS 000
		Usuario user1 = new Usuario(null, "tardio@", "123");
		Usuario user2 = new Usuario(null, "xxxxx@", "123");
		Telefone t1 = new Telefone(null, "329889992896", "residencial", user1);
		UsuarioEmail ue1 = new UsuarioEmail(null, "Seu@seu", "Trabalho", user1);

		ProdutoValidade pv1 = new ProdutoValidade(null, "03 MESES");
		ProdutoTipo pt1 = new ProdutoTipo(null, "CPF");
		ProdutoTipo pt2 = new ProdutoTipo(null, "CNPJ");

		produtoTipoRepo.saveAll(Arrays.asList(pt1, pt2));
		produtoValidadeRepo.saveAll(Arrays.asList(pv1));

		Produto p1 = new Produto(null, "ACC - AA PF", 50.00, pd1, pt1, pv1, TipoProduto.PESSOAFISICA);
		Produto p2 = new Produto(null, "ACC - AA JF", 50.00, pd1, pt1, null, TipoProduto.PESSOAFISICA);
		Produto p3 = new Produto(null, "ACC - AA JF", 50.00, pd2, pt2, null, TipoProduto.PESSOAFISICA);

		pd1.getProdutos().addAll(Arrays.asList(p1, p2));
		pd2.getProdutos().addAll(Arrays.asList(p2));
		pt1.getProdutos().addAll(Arrays.asList(p1, p2));
		pt1.getProdutos().addAll(Arrays.asList(p3));
		pv1.getProdutos().addAll(Arrays.asList(p1));
		user1.getTelefones().addAll(Arrays.asList(t1));
		user1.getUsuarioEmails().addAll(Arrays.asList(ue1));

		produtoRepo.saveAll(Arrays.asList(p1, p2, p3));
		usuarioRepository.save(user1);
		usuarioRepository.save(user2);
		telefoneRepo.saveAll(Arrays.asList(t1));
		usuarioEmailRepo.saveAll(Arrays.asList(ue1));

		// TESTANDO UM PARA UM

		SimpleDateFormat stf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, stf.parse("30/09/2017 10:32"), null, null, null, null);
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		// associar pessoa ao pedido depois
		// Items de pedido

		pedidoRepo.saveAll(Arrays.asList(ped1));
		pagamentoRepo.saveAll(Arrays.asList(pagto1));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.0);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.0);
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip1));
		itemPedidoRepo.saveAll(Arrays.asList(ip1, ip2));

	}

}
