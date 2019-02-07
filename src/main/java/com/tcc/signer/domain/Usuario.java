package com.tcc.signer.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique=true)
	private String login;
	@JsonIgnore
	private String senha;

	
	@OneToMany(mappedBy = "usuario",cascade=CascadeType.ALL)
	private List<Telefone> telefones = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "usuario",cascade=CascadeType.ALL)
	private List<UsuarioEmail> usuarioEmails = new ArrayList<>();
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="usuario")
	private Cliente cliente;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="usuario")
	private Funcionario funcionario;

	public Usuario() {
	}

	public Usuario(Integer id, String login, String senha) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	
	public List<UsuarioEmail> getUsuarioEmails() {
		return usuarioEmails;
	}

	public void setUsuarioEmails(List<UsuarioEmail> usuarioEmails) {
		this.usuarioEmails = usuarioEmails;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
