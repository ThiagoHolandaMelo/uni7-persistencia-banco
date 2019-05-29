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
}
