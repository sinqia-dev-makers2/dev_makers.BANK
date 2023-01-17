package Models;

public class Conta {

	private PessoaFisica titularPF;
	private PessoaJuridica titularPJ;
	private int agencia;
	private int conta;
	private int senha;
	private double saldo;
	
	public PessoaFisica getTitularPF() {
		return titularPF;
	}
	
	public void setTitularPF(PessoaFisica titularPF) {
		this.titularPF = titularPF;
	}
	
	public PessoaJuridica getTitularPJ() {
		return titularPJ;
	}
	
	public void setTitularPJ(PessoaJuridica titularPJ) {
		this.titularPJ = titularPJ;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	public int getConta() {
		return conta;
	}
	
	public void setConta(int conta) {
		this.conta = conta;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}
	
}
