package com.tcc.signer.domain.enums;

public enum TipoProduto {

	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2,"Pessoa Jurídica");

	private int cod;
	private String descricao;

	private TipoProduto(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoProduto toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for ( TipoProduto x :  TipoProduto.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("ID Inválido" + cod);
	}

}
