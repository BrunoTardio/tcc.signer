package com.tcc.signer.dto;

import org.hibernate.validator.constraints.br.CNPJ;

public class PessoaJuridicaDTO {
	
	
	private String nomeEmpresa;
	private String fantasia;
	@CNPJ
	private String cnpj;
	private String inscricaoEstadual;
	private String tributacao; // avaliar possibilidade de tabela

}
