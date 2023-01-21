package conta.pj;

import conta.modelos.Conta;
import conta.modelos.TipoConta;

public class ContaPJ extends Conta {
    TipoContaPJ tipoContaPJ;
    
    protected ContaPJ(String numConta) {
        super(numConta + "-1");
        txTransferencia = 1.005;
        txSaque = 1.005;
    }
    
    @Override
    public void criarConta(TipoConta tipoConta) {
        String numConta = "2001"; // a definir ainda
        double saldoInicial = 0;
        switch (tipoConta) {
            case CORRENTE -> new ContaPJCorrente(numConta, saldoInicial);
            case INVESTIMENTO -> new ContaPJInvestimento(numConta, saldoInicial);
        }
    }
    
    public TipoContaPJ getTipoDeConta() {
        return tipoContaPJ;
    }
}
