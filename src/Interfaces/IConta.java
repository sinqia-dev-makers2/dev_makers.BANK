package Interfaces;

public interface IConta<T> {

	void sacar(T conta, double valor);
	
	void depositar(T conta, double valor);
	
	void transferir(T contaOrigem, T contaDestino, double valor);
	
	double consultarSaldo(T conta);
	
}
