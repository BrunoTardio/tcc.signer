package com.tcc.signer.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tcc.signer.domain.ProdutoDescricao;
import com.tcc.signer.domain.Usuario;
import com.tcc.signer.dto.ProdutoDescricaoDTO;
import com.tcc.signer.dto.UsuarioDTO;
import com.tcc.signer.dto.UsuarioNewDTO;
import com.tcc.signer.services.UsuarioService;





@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> find(@PathVariable Integer id) {
		Usuario obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioNewDTO objDto){	
		Usuario obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();  
		return ResponseEntity.created(uri).build();
	}
	

	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody UsuarioDTO objDto,@PathVariable Integer id){
		Usuario obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
	return ResponseEntity.noContent().build();
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> list = service.findAll();
		List<UsuarioDTO> listDto = 
				list.stream().map(obj -> new UsuarioDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	
	@RequestMapping(value ="/page",method = RequestMethod.GET)
	public ResponseEntity<Page<UsuarioDTO>> findPage(
			@RequestParam(value="page",defaultValue="0")Integer page, 
			@RequestParam(value="linesPerPage",defaultValue="24")Integer linesPerPage,
			@RequestParam(value="orderBy",defaultValue="descricao")String orderBy, 
			@RequestParam(value="direction",defaultValue="ASC")String direction) {            
		Page<Usuario> list = service.findPage(page,linesPerPage,orderBy,direction);
		Page<UsuarioDTO> listDto = 
				list.map(obj -> new UsuarioDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
	

}
