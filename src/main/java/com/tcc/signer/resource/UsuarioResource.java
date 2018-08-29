package com.tcc.signer.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "usuarios")
public class UsuarioResource {

	
	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "REST esta ok";
	}
	
	
}
