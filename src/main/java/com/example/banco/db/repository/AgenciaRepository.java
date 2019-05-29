package com.example.banco.db.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.banco.db.Agencia;
import com.example.banco.db.Cliente;
import com.example.banco.db.ContaCorrente;

public interface AgenciaRepository extends CrudRepository<Agencia, Long>{

	Agencia findByNome(String nome);
}
