package com.tcc.signer.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.signer.domain.AlocacaoFuncionario;
import com.tcc.signer.services.AlocacaoFuncionarioService;

@RestController
@RequestMapping(value="/alocacaofuncionarios")
public class AlocacaoFuncionarioResource {

	@Autowired
	private AlocacaoFuncionarioService alocacaoFuncionarioService;

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		AlocacaoFuncionario obj = alocacaoFuncionarioService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
