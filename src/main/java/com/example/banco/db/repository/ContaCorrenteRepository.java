package com.example.banco.db.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.banco.db.Cliente;
import com.example.banco.db.ContaCorrente;

public interface ContaCorrenteRepository extends CrudRepository<ContaCorrente, Long>{

	ContaCorrente findByCliente(Cliente cliente);
	
}
