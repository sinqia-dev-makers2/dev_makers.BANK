package conta.pf;

import conta.Conta;
import conta.TipoDeConta;

public abstract class ContaPF extends Conta {
    private ContaPF(String numConta, String senha, TipoDeConta tipoDeConta, double saldo) {
        super(numConta, tipoDeConta);
        // code
    }
}
