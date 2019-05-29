package com.example.banco.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.banco.db.ContaCorrente;
import com.example.banco.db.Movimentacoes;

public interface MovimentacoesRepository extends CrudRepository<Movimentacoes, Long>{

	List<Movimentacoes> findByContacorrente(ContaCorrente contacorrente);
	
	//@Query("SELECT m FROM movimentacoes m WHERE m.contacorrente.agencia.nome = ?1")
	//List<Movimentacoes> findAllForAgencia(String agenciaName);
}
