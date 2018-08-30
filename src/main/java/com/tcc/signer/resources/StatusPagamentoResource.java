package com.tcc.signer.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.signer.domain.StatusPagamento;
import com.tcc.signer.services.StatusPagamentoService;

@RestController
@RequestMapping(value = "/statuspagamentos")
public class StatusPagamentoResource {

	@Autowired
	private StatusPagamentoService statusPagamentoService;

	@RequestMapping(value= "/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		StatusPagamento obj = statusPagamentoService.buscar(id);
		return ResponseEntity.ok().body(obj);

	}

}
