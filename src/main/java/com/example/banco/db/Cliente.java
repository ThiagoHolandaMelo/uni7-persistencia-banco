package com.example.banco.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "clientes")
public class Cliente {
	
	protected Cliente() {
		
	}
	
	public Cliente(String nome, String cgccpf) {
		this.nome = nome;
		this.cgccpf = cgccpf;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String cgccpf;

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

	public String getCgccpf() {
		return cgccpf;
	}

	public void setCgccpf(String cgccpf) {
		this.cgccpf = cgccpf;
	}
	
	
}
