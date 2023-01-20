package conta.pf;

import conta.modelos.Conta;

public abstract class ContaPF extends Conta {
    TipoContaPF tipoContaPF;
    protected double txRendimento = 0.000;
    protected double txTransferencia = 0.000;
    protected double txSaque = 0.000;
    
    protected ContaPF(String numConta) {
        super(numConta + "-1");
    }
    
    public TipoContaPF getTipoDeConta() {
        return tipoContaPF;
    }
    
}
