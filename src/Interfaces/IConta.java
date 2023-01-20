package Interfaces;

import Enums.TipoConta;
import Models.ContaCorrente;

public interface IConta {
	
	int getAgencia();
	
	int getNumConta();
	
	int getSenha();
	
	TipoConta getTipoConta();
	
	void sacar(double valor);
	
	void depositar(double valor);
	
	void transferir(ContaCorrente contaDestino, double valor);
	
	void atualizarSaldo(double saldo, double valor);
	
	double consultarSaldo();
	
}
