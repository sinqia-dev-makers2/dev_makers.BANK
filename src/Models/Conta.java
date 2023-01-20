package Models;

import Enums.TipoConta;

public class Conta {

	private int agencia;
	private int conta;
	private int senha;
	private TipoConta tipoConta;
	private double saldo;

	public int getAgencia() {
		return agencia;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	public int getSenha() {
		return senha;
	}
	
	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	public int getNumConta() {
		return conta;
	}
	
	public void setNumConta(int conta) {
		this.conta = conta;
	}
	
	public TipoConta getTipoConta() {
		return tipoConta;
	}
	
	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
