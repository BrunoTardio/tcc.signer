package com.tcc.signer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tcc.signer.domain.ProdutoDescricao;
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
		find(obj.getId());
		return repo.save(obj);
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

}
