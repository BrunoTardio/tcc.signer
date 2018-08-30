package com.tcc.signer.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.signer.domain.StatusNotificacao;
import com.tcc.signer.services.StatusNotificacaoService;

@RestController
@RequestMapping(value = "/statusnotificacoes")
public class StatusNotificacaoResource {

	@Autowired
	private StatusNotificacaoService statusNotificacaoService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		StatusNotificacao obj = statusNotificacaoService.buscar(id);
		return ResponseEntity.ok().body(obj);

	}

}
