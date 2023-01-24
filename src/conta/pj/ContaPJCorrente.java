package conta.pj;

import conta.modelos.TipoConta;

public class ContaPJCorrente extends ContaPJ {
    TipoConta tipoContaPJ = TipoConta.PJ_CORRENTE;
    
    public ContaPJCorrente(String numConta, double saldo) {
        super(numConta + "1");
        this.saldo = saldo;
    }
    
}