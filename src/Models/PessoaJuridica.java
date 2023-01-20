package Models;

import Enums.TipoPessoa;

public class PessoaJuridica extends Pessoa {
	
	private final String 		cnpj;
	private final TipoPessoa 	tipoPessoa = TipoPessoa.PJ;
	
	public PessoaJuridica(String nome, int idade, String cnpj, ContaCorrente conta) {
		setNome(nome);
		setIdade(idade);
		this.cnpj = cnpj;
		setConta(conta);
	}
	
	public PessoaJuridica(String nome, int idade, String cnpj, ContaInvestimento conta) {
		setNome(nome);
		setIdade(idade);
		this.cnpj = cnpj;
		setConta(conta);
	}

	public String getCnpj() {
		return cnpj;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}	
}
