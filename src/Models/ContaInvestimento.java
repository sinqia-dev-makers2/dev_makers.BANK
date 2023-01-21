package Models;

import Enums.TipoConta;
import Interfaces.IConta;
import Interfaces.IContaCI;

public class ContaInvestimento extends Conta implements IConta, IContaCI {

	public ContaInvestimento(int agencia, int conta, int senha) {
		setAgencia(agencia);
		setNumConta(conta);
		setSenha(senha);
		setTipoConta(TipoConta.CI);
		setSaldo(0);
	}
	
	@Override
	public void investir(double valor) {
		atualizarSaldo(consultarSaldo(), valor);
	}
	
	@Override
	public void sacar(double valor) {
		atualizarSaldo(consultarSaldo(), -valor);
	}
	
	@Override
	public void atualizarSaldo(double saldo, double valor) {
		setSaldo(saldo + valor);
	}

	@Override
	public double consultarSaldo() {
		return getSaldo();
	}
	
}
