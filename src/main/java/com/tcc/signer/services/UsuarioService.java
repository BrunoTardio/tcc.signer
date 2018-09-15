package com.tcc.signer.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tcc.signer.domain.ProdutoDescricao;
import com.tcc.signer.domain.Telefone;
import com.tcc.signer.domain.Usuario;
import com.tcc.signer.domain.UsuarioEmail;
import com.tcc.signer.domain.Usuario;
import com.tcc.signer.dto.UsuarioDTO;
import com.tcc.signer.dto.UsuarioNewDTO;
import com.tcc.signer.repositories.TelefoneRepository;
import com.tcc.signer.repositories.UsuarioEmailRepository;
import com.tcc.signer.repositories.UsuarioRepository;
import com.tcc.signer.services.exceptions.DataIntegrityException;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private TelefoneRepository repoTel;
	
	@Autowired
	private UsuarioEmailRepository repoEmail;
	

	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return  obj.orElse(null);
	}
	
	

	public Usuario insert(Usuario obj) {
		obj.setId(null);
		obj = repo.save(obj);
		repoEmail.saveAll(obj.getUsuarioEmails());
		repoTel.saveAll(obj.getTelefones());
		return obj;
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
	
	public Usuario fromDTO(UsuarioNewDTO objDto) {
		// se for LISTA usa o optional , se for unico findone - 1 pra 1
		// Optional<Telefone> tel = repoTel.findById(objDto.getTelefoneId());
		// ex : cidade vem codigo - ver video aula // se tiver enum usar toEnum().
		Usuario user = new Usuario(null, objDto.getLogin(), objDto.getSenha());
		Telefone tel1 = new Telefone(null, objDto.getTel1(), objDto.getDescricao(), user);
		UsuarioEmail email = new UsuarioEmail(null, objDto.getEmail(), objDto.getDescricao(), user);

		// se puxar alguem do banco tem que atualizar o obj criado associado.

		user.getUsuarioEmails().add(email);
		user.getTelefones().add(tel1);
		if (objDto.getTel2() != null) {
			Telefone tel2 = new Telefone(null, objDto.getTel2(), objDto.getDescricao(), user);
			user.getTelefones().add(tel2);
		}
		if (objDto.getTel3() != null) {
			Telefone tel3 = new Telefone(null, objDto.getTel3(), objDto.getDescricao(), user);
			user.getTelefones().add(tel3);
		}

		return user;

	}
	
	
	private void updateDate(Usuario newObj, Usuario obj) {
		newObj.setLogin(obj.getLogin());
		newObj.setSenha(obj.getSenha());
	}
	
	
}
