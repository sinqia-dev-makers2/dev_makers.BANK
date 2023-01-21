package Models;

import Enums.TipoConta;
import Interfaces.IConta;
import Interfaces.IContaCC_CP;

public class ContaPoupanca extends Conta implements IConta, IContaCC_CP {

	public ContaPoupanca(int agencia, int conta, int senha) {
		setAgencia(agencia);
		setNumConta(conta);
		setSenha(senha);
		setTipoConta(TipoConta.CP);
		setSaldo(0);
	}

	@Override
	public void sacar(double valor) {
		atualizarSaldo(consultarSaldo(), -valor);
	}

	@Override
	public void depositar(double valor) {
		atualizarSaldo(consultarSaldo(), valor);
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
