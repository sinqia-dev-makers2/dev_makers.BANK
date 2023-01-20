package Interfaces;

public interface IPessoa<T> {

	String getNome();
	int getIdade();
	IConta getConta();
	String getCpfCpnj();
	T getTipoPessoa();
	
}
