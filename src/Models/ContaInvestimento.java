package Models;

import Enums.TipoConta;
import Enums.TipoPessoa;
import Interfaces.IConta;

public class ContaInvestimento extends Conta implements IConta<ContaInvestimento> {

	public ContaInvestimento(int agencia, int conta, int senha) {
		setAgencia(agencia);
		setNumConta(conta);
		setSenha(senha);
		setTipoConta(TipoConta.CI);
	}
	
	public void investir(double valor) {
		
	}

	@Override
	public void sacar(double valor) {
		
	}

	@Override
	public void depositar(double valor) {}

	@Override
	public void transferir(ContaInvestimento contaDestino, double valor) {}

	@Override
	public void atualizarSaldo(double saldo, double valor) {
		
	}

	@Override
	public void consultarSaldo() {
		
	}
	
}
