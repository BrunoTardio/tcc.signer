package com.tcc.signer.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.signer.domain.AlocacaoFuncionario;
import com.tcc.signer.repositories.AlocacaoFuncionarioRepository;

@Service
public class AlocacaoFuncionarioService {
	
	
	
	@Autowired
	private AlocacaoFuncionarioRepository alocacaoFuncionarioRepo;

	public AlocacaoFuncionario buscar(Integer id) {
		Optional<AlocacaoFuncionario> obj = alocacaoFuncionarioRepo.findById(id);
		return obj.orElse(null);
	}

}
