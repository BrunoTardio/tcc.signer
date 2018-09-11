package com.tcc.signer.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class StatusPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idStatusPedido;
	private String descricaoPedido;

	@JsonBackReference
	@OneToMany(mappedBy = "statusPedido")
	private List<Pedido> pedidos = new ArrayList<>();

	public StatusPedido() {
	}

	public StatusPedido(Integer idStatusPedido, String descricaoPedido) {
		super();
		this.idStatusPedido = idStatusPedido;
		this.descricaoPedido = descricaoPedido;
	}

	public Integer getIdStatusPedido() {
		return idStatusPedido;
	}

	public void setIdStatusPedido(Integer idStatusPedido) {
		this.idStatusPedido = idStatusPedido;
	}

	public String getDescricaoPedido() {
		return descricaoPedido;
	}

	public void setDescricaoPedido(String descricaoPedido) {
		this.descricaoPedido = descricaoPedido;
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
		result = prime * result + ((idStatusPedido == null) ? 0 : idStatusPedido.hashCode());
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
		StatusPedido other = (StatusPedido) obj;
		if (idStatusPedido == null) {
			if (other.idStatusPedido != null)
				return false;
		} else if (!idStatusPedido.equals(other.idStatusPedido))
			return false;
		return true;
	}

}
