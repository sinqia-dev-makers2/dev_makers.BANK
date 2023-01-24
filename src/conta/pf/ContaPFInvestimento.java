package conta.pf;

import conta.modelos.TipoConta;

public class ContaPFInvestimento extends ContaPF {
    TipoConta tipoContaPF = TipoConta.PF_INVESTIMENTO;
    
    public ContaPFInvestimento(String numConta, double saldo) {
        super(numConta + "3");
        this.saldo = saldo;
        txRendimento = 1.015;
    }
    
}
