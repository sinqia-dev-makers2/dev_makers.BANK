package Interfaces;

import Enums.TipoConta;

public interface IConta<T> {
	
	int getAgencia();
	
	int getNumConta();
	
	int getSenha();
	
	TipoConta getTipoConta();
	
	void sacar(double valor);
	
	void depositar(double valor);
	
	void transferir(T contaDestino, double valor);
	
	void atualizarSaldo(double saldo, double valor);
	
	void consultarSaldo();
	
}
