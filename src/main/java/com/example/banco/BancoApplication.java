package com.example.banco;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.banco.db.Agencia;
import com.example.banco.db.Cliente;
import com.example.banco.db.ContaCorrente;
import com.example.banco.db.Movimentacoes;
import com.example.banco.db.repository.AgenciaRepository;
import com.example.banco.db.repository.ClienteRepository;
import com.example.banco.db.repository.ContaCorrenteRepository;
import com.example.banco.db.repository.MovimentacoesRepository;
import com.example.banco.db.repository.VetRepository;

@SpringBootApplication
public class BancoApplication {
	
	/*
	 * 	a. Cadastro de clientes:
			▪ Pessoa física ou pessoa jurídica
		b. Cadastro de agência;
		c. Cadastro de conta corrente;
	 */
	@Bean
	public CommandLineRunner iniciarCadastro(AgenciaRepository repositoryAgencia, 
											 ClienteRepository clienteRepository,
											 ContaCorrenteRepository contaCorrenteRepository) {
		
        return (args) -> {
        	//repository.findAll().forEach(System.out::println);
        	
        	Agencia agenciaAldeota = repositoryAgencia.save(new Agencia( "Aldeota", "27936"));
        	Agencia agenciaCentro = repositoryAgencia.save(new Agencia( "Centro", "12367"));
        	
        	Cliente clienteJoaoPF = clienteRepository.save(new Cliente("JoãoPF", "123-456-789-00"));
        	Cliente clienteMariaPF = clienteRepository.save(new Cliente("MariaPF", "123-111-789-00"));
        	
        	Cliente clienteMarcosPJ = clienteRepository.save(new Cliente("MarcosPJ", "29.649.015/0001-67"));
        	Cliente clienteAndrePJ = clienteRepository.save(new Cliente("AndrePJ", "07.715.407/0001-44"));
        	
        	ContaCorrente contaJoaoPF = contaCorrenteRepository.save(new ContaCorrente(clienteJoaoPF, agenciaAldeota));
        	ContaCorrente contaMariaPF = contaCorrenteRepository.save(new ContaCorrente(clienteMariaPF, agenciaCentro));
        	ContaCorrente contaMarcosPJ = contaCorrenteRepository.save(new ContaCorrente(clienteMarcosPJ, agenciaAldeota));
        	ContaCorrente contaAndrePJ = contaCorrenteRepository.save(new ContaCorrente(clienteAndrePJ, agenciaCentro));
        	
        };
	}
	
	/*
	 *	d. Movimentação da conta corrente: saques e depósitos; 
	 */
	@Bean
	public CommandLineRunner criarMovimentacoes(MovimentacoesRepository movimentacoesRepository,
												ContaCorrenteRepository contaCorrenteRepository,
												ClienteRepository clienteRepository) {
		
		return (args) -> {
			
			double deposito = 10;
			double saque = -10;
			
			/* Coletando os clientes e usas respectivas contas*/
			Cliente clienteMarcosPJ = clienteRepository.findByCgccpf("29.649.015/0001-67");			
			ContaCorrente contaCorrenteMarcos = contaCorrenteRepository.findByCliente(clienteMarcosPJ);
			
			Cliente clienteJoaoPF = clienteRepository.findByCgccpf("123-456-789-00");			
			ContaCorrente contaCorrenteJoaoPF = contaCorrenteRepository.findByCliente(clienteJoaoPF);
			
			//TODO: garantir que se ocorrer problema o saldo seja retornado
			/* Criando as movimentações do MarcosPJ*/
			
			contaCorrenteMarcos.setSaldo(contaCorrenteMarcos.getSaldo() + deposito);
			contaCorrenteRepository.save(contaCorrenteMarcos);
			movimentacoesRepository.save(new Movimentacoes(deposito, contaCorrenteMarcos));
			
			contaCorrenteMarcos.setSaldo(contaCorrenteMarcos.getSaldo() + saque);
			contaCorrenteRepository.save(contaCorrenteMarcos);
			movimentacoesRepository.save(new Movimentacoes(saque, contaCorrenteMarcos));
			
			contaCorrenteMarcos.setSaldo(contaCorrenteMarcos.getSaldo() + saque);
			contaCorrenteRepository.save(contaCorrenteMarcos);
			movimentacoesRepository.save(new Movimentacoes(saque, contaCorrenteMarcos));
			
			/* Criando as movimentacoes do JoaoPF*/
			
			contaCorrenteJoaoPF.setSaldo(contaCorrenteJoaoPF.getSaldo() + saque);
			contaCorrenteRepository.save(contaCorrenteJoaoPF);
			movimentacoesRepository.save(new Movimentacoes(saque, contaCorrenteJoaoPF));
			
			contaCorrenteJoaoPF.setSaldo(contaCorrenteJoaoPF.getSaldo() + saque);
			contaCorrenteRepository.save(contaCorrenteJoaoPF);
			movimentacoesRepository.save(new Movimentacoes(saque, contaCorrenteJoaoPF));
			
			contaCorrenteJoaoPF.setSaldo(contaCorrenteJoaoPF.getSaldo() + saque);
			contaCorrenteRepository.save(contaCorrenteJoaoPF);
			movimentacoesRepository.save(new Movimentacoes(saque, contaCorrenteJoaoPF));
			
		};
	}
	
	/*
	 *	e. Transferências entre contas correntes do banco; 
	 */
	@Bean
	public CommandLineRunner transferirEntreContas(	MovimentacoesRepository movimentacoesRepository,
													ContaCorrenteRepository contaCorrenteRepository,
													ClienteRepository clienteRepository) {
		
		return (args) -> {
			
			double deposito = 10;
			double saque = -10;
			
			/* Coletando os clientes e usas respectivas contas*/
			Cliente clienteMarcosPJ = clienteRepository.findByCgccpf("29.649.015/0001-67");			
			ContaCorrente contaCorrenteMarcosPJ = contaCorrenteRepository.findByCliente(clienteMarcosPJ);
			
			Cliente clienteJoaoPF = clienteRepository.findByCgccpf("123-456-789-00");			
			ContaCorrente contaCorrenteJoaoPF = contaCorrenteRepository.findByCliente(clienteJoaoPF);
			
			/* Transferindo 10 reais da conta do MarcosPJ para joaoPF */
			contaCorrenteMarcosPJ.setSaldo(contaCorrenteMarcosPJ.getSaldo() + saque);
			contaCorrenteRepository.save(contaCorrenteMarcosPJ);
			
			contaCorrenteJoaoPF.setSaldo(contaCorrenteJoaoPF.getSaldo() + deposito);
			contaCorrenteRepository.save(contaCorrenteJoaoPF);
			
			movimentacoesRepository.save(new Movimentacoes(saque, contaCorrenteMarcosPJ));
			movimentacoesRepository.save(new Movimentacoes(deposito, contaCorrenteJoaoPF));
			
		};
		
	}
	
	/*
	 *	f. Relatório com as movimentações financeiras:
		▪ Por período: dia, mês, ano;
		▪ Por agência;
		▪ Por cliente; 
	 */
	@Bean
	public CommandLineRunner relatorioPorAgencia(	MovimentacoesRepository movimentacoesRepository,
													ContaCorrenteRepository contaCorrenteRepository,
													ClienteRepository clienteRepository,
													AgenciaRepository agenciaRepository) {
		return (args) -> {
			
			Agencia agenciaAldeota = agenciaRepository.findByNome("Aldeota");
			
			
			List<Movimentacoes> movimentacoes = (List<Movimentacoes>)movimentacoesRepository.findByContacorrenteAgencia(agenciaAldeota);
			
			System.out.println("Listando Movimentações da agencia: " + agenciaAldeota.getNome() );
			movimentacoes.forEach(System.out::println);
			
			
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BancoApplication.class, args);
	}

}
