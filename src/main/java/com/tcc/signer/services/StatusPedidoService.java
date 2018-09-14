package com.tcc.signer.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.signer.domain.StatusPedido;
import com.tcc.signer.repositories.StatusPedidoRepository;

@Service
public class StatusPedidoService {

	@Autowired
	private StatusPedidoRepository repo;

	public StatusPedido find(Integer id) {
		Optional<StatusPedido> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
