package com.tcc.signer.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PessoaFisicaEleitor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	private String EleitorNumero;
	private String EleitorSecao;
	private String EleitorZona;
	private String EleitorCidade;
	private String EleitorUF;
	
	public PessoaFisicaEleitor() {}

	public PessoaFisicaEleitor(String id, String eleitorNumero, String eleitorSecao, String eleitorZona,
			String eleitorCidade, String eleitorUF) {
		super();
		this.id = id;
		EleitorNumero = eleitorNumero;
		EleitorSecao = eleitorSecao;
		EleitorZona = eleitorZona;
		EleitorCidade = eleitorCidade;
		EleitorUF = eleitorUF;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEleitorNumero() {
		return EleitorNumero;
	}

	public void setEleitorNumero(String eleitorNumero) {
		EleitorNumero = eleitorNumero;
	}

	public String getEleitorSecao() {
		return EleitorSecao;
	}

	public void setEleitorSecao(String eleitorSecao) {
		EleitorSecao = eleitorSecao;
	}

	public String getEleitorZona() {
		return EleitorZona;
	}

	public void setEleitorZona(String eleitorZona) {
		EleitorZona = eleitorZona;
	}

	public String getEleitorCidade() {
		return EleitorCidade;
	}

	public void setEleitorCidade(String eleitorCidade) {
		EleitorCidade = eleitorCidade;
	}

	public String getEleitorUF() {
		return EleitorUF;
	}

	public void setEleitorUF(String eleitorUF) {
		EleitorUF = eleitorUF;
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
		PessoaFisicaEleitor other = (PessoaFisicaEleitor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
