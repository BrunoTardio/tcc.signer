package com.tcc.signer.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.signer.domain.ProdutoDescricao;
import com.tcc.signer.services.ProdutoDescricaoService;

@RestController
@RequestMapping(value = "/produtodescricoes")
public class ProdutoDescricaoResource {

	@Autowired
	private ProdutoDescricaoService produtoDescricaoService;

	@RequestMapping(value = "{/id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		ProdutoDescricao obj = produtoDescricaoService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
