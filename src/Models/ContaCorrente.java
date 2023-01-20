package Models;

import Enums.TipoConta;
import Interfaces.IConta;

public class ContaCorrente extends Conta implements IConta<ContaCorrente> {

	public ContaCorrente(int agencia, int conta, int senha) {
		setAgencia(agencia);
		setNumConta(conta);
		setSenha(senha);
		setTipoConta(TipoConta.CC);
	}

	@Override
	public void sacar(double valor) {
		
	}

	@Override
	public void depositar(double valor) {
		
	}

	@Override
	public void transferir(ContaCorrente contaDestino, double valor) {
		
	}
	
	@Override
	public void atualizarSaldo(double saldo, double valor) {
		
	}

	@Override
	public void consultarSaldo() {
		
	}

}
