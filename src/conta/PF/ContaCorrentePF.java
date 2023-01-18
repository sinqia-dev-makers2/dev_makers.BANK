package conta.PF;

import conta.Conta;
import enumeraveis.TipoDeConta;

public class ContaCorrentePF extends Conta {
    public ContaCorrentePF(String numConta, String senha, TipoDeConta tipoDeConta, double saldo) {
        super(numConta, senha, tipoDeConta, saldo);
    }

    void atualizaSaldo(double valor){
        setSaldo(getSaldo() - valor);
    }
}
