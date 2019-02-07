package com.tcc.signer.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PessoaFisicaEleitor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String eleitorNumero;
	private String eleitorSecao;
	private String eleitorZona;
	private String eleitorCidade;
	private String eleitorUF;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="pessoaFisicaId")
	@MapsId
	PessoaFisica pessoaFisica;
	
	public PessoaFisicaEleitor() {}

	public PessoaFisicaEleitor(String id, String eleitorNumero, String eleitorSecao, String eleitorZona,
			String eleitorCidade, String eleitorUF,PessoaFisica pessoaFisica) {
		super();
		this.id = id;
		this.eleitorNumero = eleitorNumero;
		this.eleitorSecao = eleitorSecao;
		this.eleitorZona = eleitorZona;
		this.eleitorCidade = eleitorCidade;
		this.eleitorUF = eleitorUF;
		this.pessoaFisica = pessoaFisica;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEleitorNumero() {
		return eleitorNumero;
	}

	public void setEleitorNumero(String eleitorNumero) {
		eleitorNumero = eleitorNumero;
	}

	public String getEleitorSecao() {
		return eleitorSecao;
	}

	public void setEleitorSecao(String eleitorSecao) {
		eleitorSecao = eleitorSecao;
	}

	public String getEleitorZona() {
		return eleitorZona;
	}

	public void setEleitorZona(String eleitorZona) {
		eleitorZona = eleitorZona;
	}

	public String getEleitorCidade() {
		return eleitorCidade;
	}

	public void setEleitorCidade(String eleitorCidade) {
		eleitorCidade = eleitorCidade;
	}

	public String getEleitorUF() {
		return eleitorUF;
	}

	public void setEleitorUF(String eleitorUF) {
		eleitorUF = eleitorUF;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
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
