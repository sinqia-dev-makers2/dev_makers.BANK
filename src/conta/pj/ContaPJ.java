package conta.pj;

import conta.modelos.Conta;
import conta.modelos.TipoConta;
import conta.pf.ContaPFCorrente;
import conta.pf.ContaPFInvestimento;

public class ContaPJ extends Conta {
    TipoContaPJ tipoContaPJ;
    protected double txRendimento = 0.000;
    protected double txTransferencia = 0.005;
    protected double txSaque = 0.005;
    
    protected ContaPJ(String numConta) {
        super(numConta + "-1");
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
