package com.tcc.signer.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.signer.domain.StatusNotificacao;
import com.tcc.signer.repositories.StatusNotificacaoRepository;

@Service
public class StatusNotificacaoService {

	@Autowired
	private StatusNotificacaoRepository statusNotificacaoRepo;
	
	
	public StatusNotificacao buscar(Integer id) {
		Optional<StatusNotificacao> obj = statusNotificacaoRepo.findById(id);
		return obj.orElse(null);
	}

}
