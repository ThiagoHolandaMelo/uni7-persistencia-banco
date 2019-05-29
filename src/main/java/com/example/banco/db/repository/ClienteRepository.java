package com.example.banco.db.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.banco.db.Cliente;
import com.example.banco.db.ContaCorrente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
	Cliente findByCgccpf(String cgccpf);
}
