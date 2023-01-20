package Models;

import Enums.TipoPessoa;

public class PessoaFisica extends Pessoa {

	private final String 		cpf;
	private final TipoPessoa 	tipoPessoa = TipoPessoa.PF;
	
	public PessoaFisica(String nome, int idade, String cpf, ContaCorrente conta) {
		setNome(nome);
		setIdade(idade);
		this.cpf = cpf;
		setConta(conta);
	}
	
	public PessoaFisica(String nome, int idade, String cpf, ContaPoupanca conta) {
		setNome(nome);
		setIdade(idade);
		this.cpf = cpf;
		setConta(conta);
	}
	
	public PessoaFisica(String nome, int idade, String cpf, ContaInvestimento conta) {
		setNome(nome);
		setIdade(idade);
		this.cpf = cpf;
		setConta(conta);
	}

	public String getCpf() {
		return cpf;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
}
