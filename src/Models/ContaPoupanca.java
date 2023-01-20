package Models;

import Enums.TipoConta;
import Interfaces.IConta;

public class ContaPoupanca extends Conta implements IConta {

	public ContaPoupanca(int agencia, int conta, int senha) {
		setAgencia(agencia);
		setNumConta(conta);
		setSenha(senha);
		setTipoConta(TipoConta.CP);
		setSaldo(0);
	}

	@Override
	public void sacar(double valor) {
		
	}

	@Override
	public void depositar(double valor) {
		
	}

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
