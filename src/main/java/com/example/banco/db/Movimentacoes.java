package com.example.banco.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "movimentacoes")
public class Movimentacoes {

	protected Movimentacoes() {
		// TODO Auto-generated constructor stub
	}
	
	public Movimentacoes( double valor, ContaCorrente conta) {
		this.valor = valor;
		this.contacorrente = conta;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column
	private double valor;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private ContaCorrente contacorrente;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public ContaCorrente getContacorrente() {
		return contacorrente;
	}

	public void setContacorrente(ContaCorrente contacorrente) {
		this.contacorrente = contacorrente;
	}

	@Override
	public String toString() {
		
		return "Agencia: " + this.getContacorrente().getAgencia().getNome() +
				"\n Cliente: " + this.getContacorrente().getCliente().getNome() + 
				"\n Valor aplicado: " + this.getValor() + 
				"\n\n";
	}
}
