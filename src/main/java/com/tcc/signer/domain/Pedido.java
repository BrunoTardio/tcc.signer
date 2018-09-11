package com.tcc.signer.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date instante;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "pessoaFisicaId")
	private PessoaFisica pessoaFisica;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "pessoaJuridicaId")
	private PessoaJuridica pessoaJuridica;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "funcionarioId")
	private Funcionario funcionario;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "statusPedidoId")
	private StatusPedido statusPedido;

	/*@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "produtoId")
	private Produto produto;*/
	
	@OneToMany(mappedBy="id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();
	

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	private Pagamento pagamento;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	private Agenda agenda;
	
	
	

	public Pedido() {

	}

	public Pedido(Integer id, Date instante, PessoaJuridica pessoaJuridica, PessoaFisica pessoaFisica,
			Funcionario funcionario,  StatusPedido statusPedido) {
		super();
		this.id = id;
		this.instante = instante;
		this.pessoaJuridica = pessoaJuridica;
		this.pessoaFisica = pessoaFisica;
		this.funcionario = funcionario;
		
		this.statusPedido = statusPedido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}


	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
	
	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
