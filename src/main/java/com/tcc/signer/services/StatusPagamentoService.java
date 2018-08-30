package com.tcc.signer.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.signer.domain.StatusPagamento;
import com.tcc.signer.repositories.StatusPagamentoRepository;

@Service
public class StatusPagamentoService {
	
	
	@Autowired
	private StatusPagamentoRepository statusPagamentoRepo;

	public StatusPagamento buscar(Integer id) {
		Optional<StatusPagamento> obj = statusPagamentoRepo.findById(id);
		return obj.orElse(null);

	}

}
