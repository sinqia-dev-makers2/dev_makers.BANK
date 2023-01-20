package Models;

import Enums.TipoPessoa;
import Interfaces.IPessoa;

public class PessoaJuridica extends Pessoa implements IPessoa<TipoPessoa>{
	
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

	@Override
	public String getCpfCpnj() {
		return cnpj;
	}
	
	@Override
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
}
