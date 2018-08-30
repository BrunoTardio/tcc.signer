package com.tcc.signer.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StatusPagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idStatusPagamento;
	
	private String descricacaoPagamento;
	
	
	public StatusPagamento() {}


	public StatusPagamento(Integer idStatusPagamento, String descricacaoPagamento) {
		super();
		this.idStatusPagamento = idStatusPagamento;
		this.descricacaoPagamento = descricacaoPagamento;
	}


	public Integer getIdStatusPagamento() {
		return idStatusPagamento;
	}


	public void setIdStatusPagamento(Integer idStatusPagamento) {
		this.idStatusPagamento = idStatusPagamento;
	}


	public String getDescricacaoPagamento() {
		return descricacaoPagamento;
	}


	public void setDescricacaoPagamento(String descricacaoPagamento) {
		this.descricacaoPagamento = descricacaoPagamento;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricacaoPagamento == null) ? 0 : descricacaoPagamento.hashCode());
		result = prime * result + ((idStatusPagamento == null) ? 0 : idStatusPagamento.hashCode());
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
		StatusPagamento other = (StatusPagamento) obj;
		if (descricacaoPagamento == null) {
			if (other.descricacaoPagamento != null)
				return false;
		} else if (!descricacaoPagamento.equals(other.descricacaoPagamento))
			return false;
		if (idStatusPagamento == null) {
			if (other.idStatusPagamento != null)
				return false;
		} else if (!idStatusPagamento.equals(other.idStatusPagamento))
			return false;
		return true;
	}
	
	
	

}
