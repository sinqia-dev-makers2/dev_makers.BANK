package conta.pf;

import conta.modelos.TipoConta;

public class ContaPFPoupanca extends ContaPF {
    TipoConta tipoContaPF = TipoConta.PF_POUPANCA;
    
    public ContaPFPoupanca(String numConta, double saldo) {
        super(numConta + "2");
        this.saldo = saldo;
        txRendimento = 1.010;
    }
    
}
