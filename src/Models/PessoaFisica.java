package Models;

import Enums.TipoPessoa;
import Interfaces.IPessoa;

public class PessoaFisica extends Pessoa implements IPessoa<TipoPessoa> {

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

	public String getCpfCpnj() {
		return cpf;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
}
