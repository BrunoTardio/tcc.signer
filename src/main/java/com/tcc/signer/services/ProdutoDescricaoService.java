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
import com.tcc.signer.dto.ProdutoDescricaoDTO;
import com.tcc.signer.repositories.ProdutoDescricaoRepository;
import com.tcc.signer.services.exceptions.DataIntegrityException;
import com.tcc.signer.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoDescricaoService {

	@Autowired
	private ProdutoDescricaoRepository repo;

	public ProdutoDescricao find(Integer id) {
		Optional<ProdutoDescricao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + ProdutoDescricao.class.getName()));
	}

	public ProdutoDescricao insert(ProdutoDescricao obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public ProdutoDescricao update(ProdutoDescricao obj) {
		ProdutoDescricao newObj =  find(obj.getId());
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
	
	public List<ProdutoDescricao> findAll(){
		return repo.findAll();
	}

	public Page<ProdutoDescricao> findPage(Integer page, Integer linesPerPage,String orderBy, String direction){
		
		PageRequest pageRequest = new PageRequest(page,linesPerPage,Direction.valueOf(direction),orderBy);
				return repo.findAll(pageRequest);                     

	}
	
	public ProdutoDescricao fromDTO(ProdutoDescricaoDTO objDto) {
		return new ProdutoDescricao(objDto.getId(),objDto.getDescricao());
	}
	
	private void updateDate(ProdutoDescricao newObj, ProdutoDescricao obj) {
		newObj.setDescricao(obj.getDescricao());
		
	}
}
