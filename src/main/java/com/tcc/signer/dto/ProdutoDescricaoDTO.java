package com.tcc.signer.dto;

import java.io.Serializable;

import com.tcc.signer.domain.ProdutoDescricao;

public class ProdutoDescricaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descricao;

	public ProdutoDescricaoDTO() {

	}

	public ProdutoDescricaoDTO(ProdutoDescricao obj) {
		id = obj.getId();
		descricao = obj.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
