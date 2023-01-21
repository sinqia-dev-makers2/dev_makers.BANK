package Interfaces;

import Enums.TipoConta;

public interface IConta {
	
	int getAgencia();
	
	int getNumConta();
	
	int getSenha();
	
	TipoConta getTipoConta();
	
	void sacar(double valor);
	
	void atualizarSaldo(double saldo, double valor);
	
	double consultarSaldo();
	
	
}
