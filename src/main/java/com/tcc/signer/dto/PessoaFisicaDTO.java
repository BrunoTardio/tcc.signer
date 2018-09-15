package com.tcc.signer.dto;

import java.util.Date;

import org.hibernate.validator.constraints.br.CPF;

public class PessoaFisicaDTO {
	
	
	private String nome;
	
	@CPF
	private String cpf;
	private Date dataNascimento;
	private String cei;
	private String pis;
	

}
