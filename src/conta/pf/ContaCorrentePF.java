package conta.pf;

import conta.Conta;
import enumeraveis.TipoDeConta;

public class ContaCorrentePF extends Conta {
    private ContaCorrentePF(String numConta, String senha, TipoDeConta tipoDeConta, double saldo) {
        super(numConta, tipoDeConta);
        
    }

    void atualizaSaldo(double valor){
        setSaldo(getSaldo() - valor);
    }
}
