package com.tcc.signer.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class PessoaJuridica implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeEmpresa;
	private String fantasia;
	private String cnpj;
	private String inscricaoEstadual;
	private String tributacao; // avaliar possibilidade de tabela
	
	@ElementCollection
	@CollectionTable(name="TelefoneJuridica")
	private Set<String> telefones = new HashSet<>();
	
	@JsonBackReference
	@OneToMany(mappedBy="pessoaJuridica")
	private List<Pedido> pedidos = new ArrayList<>();
	
	@JsonBackReference
	@OneToMany(mappedBy="pessoaJuridica")
	private List<Endereco> enderecos = new ArrayList<>();
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="clienteId")
	private Cliente cliente;
	
	

	
	
	public PessoaJuridica() {}

	public PessoaJuridica(Integer id, String nomeEmpresa, String fantasia, String cnpj, String inscricaoEstadual,
			String tributacao,Cliente cliente) {
		super();
		this.id = id;
		this.nomeEmpresa = nomeEmpresa;
		this.fantasia = fantasia;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.tributacao = tributacao;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getTributacao() {
		return tributacao;
	}

	public void setTributacao(String tributacao) {
		this.tributacao = tributacao;
	}
	
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
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
		PessoaJuridica other = (PessoaJuridica) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
}
