package com.tcc.signer.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.tcc.signer.domain.Usuario;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="preenchimento obrigatorio")
	@Email(message="Email invalido")
	private String login;
	@NotEmpty(message="preenchimento obrigatorio")
	@Length(min=5,max=120, message="Tamanho deve ser entre 5 e 120 caracteres")
	private String senha;
	
	public UsuarioDTO () {
		
	}
	
	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
		login = obj.getLogin();
		senha = obj.getSenha();
			
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
	
}
