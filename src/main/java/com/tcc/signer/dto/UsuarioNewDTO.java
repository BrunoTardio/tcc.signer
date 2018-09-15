package com.tcc.signer.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class UsuarioNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@NotEmpty(message="preenchimento obrigatorio")
	@Email(message="Email invalido")
	private String login;
	@NotEmpty(message="preenchimento obrigatorio")
	@Length(min=5,max=120, message="Tamanho deve ser entre 5 e 120 caracteres")
	private String senha;
	
	@Email(message="Email invalido")
	private String email;
	private String descricao;
	
	@NotEmpty(message="preenchimento obrigatorio")
	@Length(min=8,max=12, message="Tamanho deve ser entre 8 e 12 caracteres")
	private String tel1;
	private String tel2;
	private String tel3;
	
	private Integer telefoneId;
	
	public UsuarioNewDTO () {
		
	}
	

	public Integer getTelefoneId() {
		return telefoneId;
	}


	public void setTelefoneId(Integer telefoneId) {
		this.telefoneId = telefoneId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getTel3() {
		return tel3;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}
	
	

}
