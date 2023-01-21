package Models;

import Enums.TipoConta;
import Interfaces.IConta;
import Interfaces.IContaCC;
import Interfaces.IContaCC_CP;

public class ContaCorrente extends Conta implements IConta, IContaCC, IContaCC_CP {

	public ContaCorrente(int agencia, int conta, int senha) {
		setAgencia(agencia);
		setNumConta(conta);
		setSenha(senha);
		setTipoConta(TipoConta.CC);
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
	public void transferir(double valor) {
		atualizarSaldo(consultarSaldo(), valor);
	}
	
	@Override
	public void receberTransferencia(double valor) {
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
