package com.tcc.signer.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PessoaFisica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nome;
	private String cpf;
	private Date dataNascimento;
	private String cei;
	private String pis;
	
	
	@OneToOne
	@JoinColumn(name="funcionarioId")
	@MapsId
	Funcionario funcionario;
	
	@OneToOne
	@JoinColumn(name="clienteId")
	@MapsId
	Cliente cliente;
	
	@JsonIgnore
	@OneToMany(mappedBy="pessoaFisica") 
	private List<Pedido> pedidos = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="pessoaFisica")
	private List<Endereco> enderecos = new ArrayList<>();
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="pessoaFisica")
	private PessoaFisicaEleitor eleitor;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="pessoaFisica")
	private PessoaFisicaRg rg;
	
	public PessoaFisica() {
	}

	public PessoaFisica(Integer id, String nome, String cpf, Date dataNascimento, String cei, String pis, Funcionario funcionario, Cliente cliente) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.cei = cei;
		this.pis = pis;
		this.funcionario = funcionario;
		this.cliente = cliente;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCei() {
		return cei;
	}

	public void setCei(String cei) {
		this.cei = cei;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}
	

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public PessoaFisicaEleitor getEleitor() {
		return eleitor;
	}

	public void setEleitor(PessoaFisicaEleitor eleitor) {
		this.eleitor = eleitor;
	}

	public PessoaFisicaRg getRg() {
		return rg;
	}

	public void setRg(PessoaFisicaRg rg) {
		this.rg = rg;
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
		PessoaFisica other = (PessoaFisica) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
