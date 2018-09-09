package com.tcc.signer.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class ProdutoDetalhe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private Double promocao;
	private Integer estoque;

	@OneToOne
	@JoinColumn(name = "produtoId")
	@MapsId
	Produto produto;

	public ProdutoDetalhe() {
	}

	public ProdutoDetalhe(Integer id, Double promocao, Integer estoque, Produto produto) {
		super();
		this.id = id;
		this.promocao = promocao;
		this.estoque = estoque;
		this.produto = produto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPromocao() {
		return promocao;
	}

	public void setPromocao(Double promocao) {
		this.promocao = promocao;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ProdutoDetalhe other = (ProdutoDetalhe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
