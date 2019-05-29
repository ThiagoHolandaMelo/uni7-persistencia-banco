package com.example.banco.db;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "agencias")
public class Agencia {
	
	protected Agencia() {
		
	}
	
	public Agencia( String nome, String numero) {
		super();
		this.nome = nome;
		this.numero = numero;		
	}
	
	public Agencia( String nome, String numero, List<ContaCorrente> contas) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.contas = contas;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String numero;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "agencia")
    private List<ContaCorrente> contas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<ContaCorrente> getContas() {
		return contas;
	}

	public void setContas(List<ContaCorrente> contas) {
		this.contas = contas;
	}
	
	
	
}
