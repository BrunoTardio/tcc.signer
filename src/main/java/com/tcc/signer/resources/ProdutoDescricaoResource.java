package com.tcc.signer.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.tcc.signer.domain.ProdutoDescricao;
import com.tcc.signer.dto.ProdutoDescricaoDTO;
import com.tcc.signer.services.ProdutoDescricaoService;

@RestController
@RequestMapping(value = "/produtodescricoes")
public class ProdutoDescricaoResource {

	@Autowired
	private ProdutoDescricaoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProdutoDescricao> find(@PathVariable Integer id) {
		ProdutoDescricao obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ProdutoDescricaoDTO objDto){	
		ProdutoDescricao obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();  
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ProdutoDescricaoDTO objDto,@PathVariable Integer id){
		ProdutoDescricao obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	// pode autorizar o END POINT para que tipo de perfil pode acessar
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
	return ResponseEntity.noContent().build();
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProdutoDescricaoDTO>> findAll() {
		List<ProdutoDescricao> list = service.findAll();
		List<ProdutoDescricaoDTO> listDto = 
				list.stream().map(obj -> new ProdutoDescricaoDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	
	@RequestMapping(value ="/page",method = RequestMethod.GET)
	public ResponseEntity<Page<ProdutoDescricaoDTO>> findPage(
			@RequestParam(value="page",defaultValue="0")Integer page, 
			@RequestParam(value="linesPerPage",defaultValue="24")Integer linesPerPage,
			@RequestParam(value="orderBy",defaultValue="descricao")String orderBy, 
			@RequestParam(value="direction",defaultValue="ASC")String direction) {            
		Page<ProdutoDescricao> list = service.findPage(page,linesPerPage,orderBy,direction);
		Page<ProdutoDescricaoDTO> listDto = 
				list.map(obj -> new ProdutoDescricaoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
	
	
	
}