package com.tcc.signer.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.signer.domain.Pedido;
import com.tcc.signer.services.PedidoService;





@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService pedidoService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Pedido obj =  pedidoService.buscar(id);
		return ResponseEntity.ok().body(obj);

	}

}
