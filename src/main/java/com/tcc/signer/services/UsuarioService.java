package com.tcc.signer.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tcc.signer.domain.Usuario;
import com.tcc.signer.domain.Usuario;
import com.tcc.signer.dto.UsuarioDTO;
import com.tcc.signer.repositories.UsuarioRepository;
import com.tcc.signer.services.exceptions.DataIntegrityException;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;

	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return  obj.orElse(null);
	}
	
	

	public Usuario insert(Usuario obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Usuario update(Usuario obj) {
		Usuario newObj =  find(obj.getId());
		updateDate(newObj, obj);
		
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Existe Produtos atrelados a este Produto Descricao");
		}
	}
	
	public List<Usuario> findAll(){
		return repo.findAll();
	}

	public Page<Usuario> findPage(Integer page, Integer linesPerPage,String orderBy, String direction){
		
		PageRequest pageRequest = new PageRequest(page,linesPerPage,Direction.valueOf(direction),orderBy);
				return repo.findAll(pageRequest);                     

	}
	
	public Usuario fromDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId(),objDto.getLogin(),objDto.getSenha());
	
	}
	
	private void updateDate(Usuario newObj, Usuario obj) {
		newObj.setLogin(obj.getLogin());
		newObj.setSenha(obj.getSenha());
	}
	
	
}
