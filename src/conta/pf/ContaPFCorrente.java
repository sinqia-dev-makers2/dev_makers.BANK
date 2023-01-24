package conta.pf;

import conta.modelos.TipoConta;

public class ContaPFCorrente extends ContaPF {
    TipoConta tipoContaPF = TipoConta.PF_CORRENTE;
    
    public ContaPFCorrente(String numConta, double saldo) {
        super(numConta + "1");
        this.saldo = saldo;
    }
    
}
