package com.tcc.signer.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AlocacaoFuncionario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAlocacaoFuncionario;
	
	private String descricacao;
	
	public AlocacaoFuncionario() {}
	
	public AlocacaoFuncionario(Integer idAlocacaoFuncionario, String descricacao) {
		super();
		this.idAlocacaoFuncionario = idAlocacaoFuncionario;
		this.descricacao = descricacao;
	}


	public Integer getIdAlocacaoFuncionario() {
		return idAlocacaoFuncionario;
	}

	public void setIdAlocacaoFuncionario(Integer idAlocacaoFuncionario) {
		this.idAlocacaoFuncionario = idAlocacaoFuncionario;
	}

	public String getDescricacao() {
		return descricacao;
	}

	public void setDescricacao(String descricacao) {
		this.descricacao = descricacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricacao == null) ? 0 : descricacao.hashCode());
		result = prime * result + ((idAlocacaoFuncionario == null) ? 0 : idAlocacaoFuncionario.hashCode());
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
		AlocacaoFuncionario other = (AlocacaoFuncionario) obj;
		if (descricacao == null) {
			if (other.descricacao != null)
				return false;
		} else if (!descricacao.equals(other.descricacao))
			return false;
		if (idAlocacaoFuncionario == null) {
			if (other.idAlocacaoFuncionario != null)
				return false;
		} else if (!idAlocacaoFuncionario.equals(other.idAlocacaoFuncionario))
			return false;
		return true;
	}

}
