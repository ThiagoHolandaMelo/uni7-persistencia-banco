package com.example.banco.db;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;

@Entity
@Table(name= "contacorrente")
public class ContaCorrente {

	protected ContaCorrente() {
		// TODO Auto-generated constructor stub
	}
	
	public ContaCorrente(Cliente cliente, Agencia agencia) {
		this.cliente = cliente;
		this.agencia = agencia;
		this.saldo = 100;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column
	private double saldo;
	
	@OneToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Agencia agencia;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "contacorrente")
	private List<Movimentacoes> movimentacoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public List<Movimentacoes> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacoes> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
}
