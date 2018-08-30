package com.tcc.signer.domain;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class StatusNotificacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Integer idStatusNotificacao;
	private String descricacaoNotificacao;
	
	public StatusNotificacao() {}

	public StatusNotificacao(Integer idStatusNotificacao, String descricacaoNotificacao) {
		super();
		this.idStatusNotificacao = idStatusNotificacao;
		this.descricacaoNotificacao = descricacaoNotificacao;
	}

	public Integer getIdStatusNotificacao() {
		return idStatusNotificacao;
	}
	public void setIdStatusNotificacao(Integer idStatusNotificacao) {
		this.idStatusNotificacao = idStatusNotificacao;
	}
	public String getDescricacaoNotificacao() {
		return descricacaoNotificacao;
	}
	public void setDescricacaoNotificacao(String descricacaoNotificacao) {
		this.descricacaoNotificacao = descricacaoNotificacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricacaoNotificacao == null) ? 0 : descricacaoNotificacao.hashCode());
		result = prime * result + ((idStatusNotificacao == null) ? 0 : idStatusNotificacao.hashCode());
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
		StatusNotificacao other = (StatusNotificacao) obj;
		if (descricacaoNotificacao == null) {
			if (other.descricacaoNotificacao != null)
				return false;
		} else if (!descricacaoNotificacao.equals(other.descricacaoNotificacao))
			return false;
		if (idStatusNotificacao == null) {
			if (other.idStatusNotificacao != null)
				return false;
		} else if (!idStatusNotificacao.equals(other.idStatusNotificacao))
			return false;
		return true;
	}
	
	

}
