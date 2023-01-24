package conta.pj;

import conta.modelos.Conta;
import conta.modelos.TipoConta;

public class ContaPJ extends Conta {
    TipoConta tipoContaPJ;
    public ContaPJCorrente contaPJCorrente;
    public ContaPJInvestimento contaPJInvestimento;
    
    protected ContaPJ(String numConta) {
        super(numConta + "-1");
        txTransferencia = 1.005;
        txSaque = 1.005;
    }
    
    @Override
    public void criarConta(TipoConta tipoConta, String idCliente) {
        String numConta = idCliente;
        double saldoInicial = 0;
        switch (tipoConta) {
            case PJ_CORRENTE -> contaPJCorrente = new ContaPJCorrente(numConta+"-21", saldoInicial);
            case PJ_INVESTIMENTO -> contaPJInvestimento = new ContaPJInvestimento(numConta+"-22", saldoInicial);
        }
    }

    public TipoConta getTipoDeConta() {
        return tipoContaPJ;
    }

    @Override
    public String getNumConta(TipoConta tipoConta) {
        String conta = null;
        switch (tipoConta){
            case PJ_CORRENTE -> conta = contaPJCorrente.numConta;
            case PJ_INVESTIMENTO ->  conta = contaPJInvestimento.numConta;
        }
        return conta;
    }
}
