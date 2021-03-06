package com.tcc.signer.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.signer.domain.StatusPedido;
import com.tcc.signer.services.StatusPedidoService;


@RestController
@RequestMapping(value = "/statuspedidos")
public class StatusPedidoResource {

	@Autowired
	private StatusPedidoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<StatusPedido> find(@PathVariable Integer id) {
		StatusPedido obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}

}
