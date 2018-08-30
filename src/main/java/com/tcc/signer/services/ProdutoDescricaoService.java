package com.tcc.signer.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.signer.domain.ProdutoDescricao;
import com.tcc.signer.repositories.ProdutoDescricaoRepository;

@Service
public class ProdutoDescricaoService {

	@Autowired
	private ProdutoDescricaoRepository produtoDescricaoRepo;

	public ProdutoDescricao buscar(Integer id) {
		Optional<ProdutoDescricao> obj = produtoDescricaoRepo.findById(id);
		return obj.orElse(null);
	}

}
