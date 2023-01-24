package conta.pj;

import conta.modelos.TipoConta;

public class ContaPJInvestimento extends ContaPJ {
    TipoConta tipoContaPJ = TipoConta.PJ_INVESTIMENTO;
    
    public ContaPJInvestimento(String numConta, double saldo) {
        super(numConta + "3");
        this.saldo = saldo;
        txRendimento = 0.035;
    }
    
}
