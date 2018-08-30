package com.tcc.signer.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity	
public class ProdutoDescricao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idProdutoDescricacao;
	
	private String descricacao;
	
	@ManyToMany(mappedBy="produtoDescricoes")
	private List<Produto> produtos = new ArrayList<>();
	
	
	
	public ProdutoDescricao() {}

	public ProdutoDescricao(Integer idProdutoDescricacao, String descricacao) {
		super();
		this.idProdutoDescricacao = idProdutoDescricacao;
		this.descricacao = descricacao;
	}

	public Integer getIdProdutoDescricacao() {
		return idProdutoDescricacao;
	}

	public void setIdProdutoDescricacao(Integer idProdutoDescricacao) {
		this.idProdutoDescricacao = idProdutoDescricacao;
	}

	public String getDescricacao() {
		return descricacao;
	}

	public void setDescricacao(String descricacao) {
		this.descricacao = descricacao;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProdutoDescricacao == null) ? 0 : idProdutoDescricacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoDescricao other = (ProdutoDescricao) obj;
		if (idProdutoDescricacao == null) {
			if (other.idProdutoDescricacao != null)
				return false;
		} else if (!idProdutoDescricacao.equals(other.idProdutoDescricacao))
			return false;
		return true;
	}



	
}
