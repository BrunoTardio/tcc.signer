package com.tcc.signer.domain;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.tcc.signer.domain.enums.TipoProduto;



@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double preco;
	private Integer tipo;
	
	
	@ManyToOne
	@JoinColumn(name="produtoDescricao_id")
	private ProdutoDescricao produtoDescricao;// atributo mapeado
	
	@ManyToOne
	@JoinColumn(name="produtoTipoId")
	private ProdutoTipo produtoTipo;
	
	@ManyToOne
	@JoinColumn(name="produtoValidadeId")
	private ProdutoValidade produtoValidade;
	
	

	public Produto() {

	}

	public Produto(Integer id, String nome, Double preco, ProdutoDescricao produtoDescricao,
			ProdutoTipo produtoTipo,ProdutoValidade produtoValidade, TipoProduto tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.produtoDescricao = produtoDescricao;
		this.produtoTipo = produtoTipo;
		this.produtoValidade = produtoValidade;
		this.tipo = tipo.getCod();// ENUM
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public ProdutoDescricao getProdutoDescricao() {
		return produtoDescricao;
	}

	public void setProdutoDescricao(ProdutoDescricao produtoDescricao) {
		this.produtoDescricao = produtoDescricao;
	}

	public ProdutoTipo getProdutoTipo() {
		return produtoTipo;
	}

	public void setProdutoTipo(ProdutoTipo produtoTipo) {
		this.produtoTipo = produtoTipo;
	}
	
	

	public ProdutoValidade getProdutoValidade() {
		return produtoValidade;
	}

	public void setProdutoValidade(ProdutoValidade produtoValidade) {
		this.produtoValidade = produtoValidade;
	}

	
	
	// ENUM
	public TipoProduto getTipo() {
		return TipoProduto.toEnum(tipo);
	}

	public void setTipo(TipoProduto tipo) {
		this.tipo = tipo.getCod();
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
