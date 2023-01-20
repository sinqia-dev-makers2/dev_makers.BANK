package conta.pj;

import conta.modelos.Conta;

public class ContaPJ extends Conta {
    TipoContaPJ tipoContaPJ;
    protected double txRendimento = 0.000;
    protected double txTransferencia = 0.005;
    protected double txSaque = 0.005;
    
    protected ContaPJ(String numConta) {
        super(numConta + "-1");
    }
    
    public TipoContaPJ getTipoDeConta() {
        return tipoContaPJ;
    }
}
