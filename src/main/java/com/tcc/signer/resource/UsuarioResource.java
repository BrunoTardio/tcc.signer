package com.tcc.signer.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcc.signer.domain.Usuario;

@RestController
@RequestMapping(value = "usuarios")
public class UsuarioResource {

	
	@RequestMapping(method = RequestMethod.GET)
	public List<Usuario> listar() {
		
		Usuario us1 = new Usuario(1,"Teste","00aa");
		Usuario us2 = new Usuario(2,"TFFF","00aaff");
		
		List<Usuario> lista = new ArrayList<>();
		lista.add(us1);
		lista.add(us2);
		
		return lista;
	}
	
	
}
