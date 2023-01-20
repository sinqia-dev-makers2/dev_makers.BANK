package Models;

import Enums.TipoConta;
import Interfaces.IConta;

public class ContaInvestimento extends Conta implements IConta {

	public ContaInvestimento(int agencia, int conta, int senha) {
		setAgencia(agencia);
		setNumConta(conta);
		setSenha(senha);
		setTipoConta(TipoConta.CI);
		setSaldo(0);
	}
	
	public void investir(double valor) {
		
	}

	@Override
	public void sacar(double valor) {
		
	}

	@Override
	public void depositar(double valor) {}

	@Override
	public void transferir(ContaCorrente contaDestino, double valor) {}

	@Override
	public void atualizarSaldo(double saldo, double valor) {
		
	}

	@Override
	public double consultarSaldo() {
		return getSaldo();
	}
	
}
