package com.tcc.signer.domain;

import java.io.Serializable;
import java.util.Date;

public class PessoaFisicaRg implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nomeTitular;
	private Date dataExpedicao;
	private String nomeDoPai;
	private String nomeDaMae;
	private String naturalidade;
	private String orgaoExpeditor; // tabela

	public PessoaFisicaRg() {
	}

	public PessoaFisicaRg(Integer id, String nomeTitular, Date dataExpedicao, String nomeDoPai, String nomeDaMae,
			String naturalidade, String orgaoExpeditor) {
		super();
		this.id = id;
		this.nomeTitular = nomeTitular;
		this.dataExpedicao = dataExpedicao;
		this.nomeDoPai = nomeDoPai;
		this.nomeDaMae = nomeDaMae;
		this.naturalidade = naturalidade;
		this.orgaoExpeditor = orgaoExpeditor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public Date getDataExpedicao() {
		return dataExpedicao;
	}

	public void setDataExpedicao(Date dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}

	public String getNomeDoPai() {
		return nomeDoPai;
	}

	public void setNomeDoPai(String nomeDoPai) {
		this.nomeDoPai = nomeDoPai;
	}

	public String getNomeDaMae() {
		return nomeDaMae;
	}

	public void setNomeDaMae(String nomeDaMae) {
		this.nomeDaMae = nomeDaMae;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getOrgaoExpeditor() {
		return orgaoExpeditor;
	}

	public void setOrgaoExpeditor(String orgaoExpeditor) {
		this.orgaoExpeditor = orgaoExpeditor;
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
		PessoaFisicaRg other = (PessoaFisicaRg) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
