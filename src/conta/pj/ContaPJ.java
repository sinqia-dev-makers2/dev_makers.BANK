package conta.pj;

import conta.modelos.Conta;
import conta.modelos.TipoConta;

public class ContaPJ extends Conta {
    TipoContaPJ tipoContaPJ;
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
            case CORRENTE -> contaPJCorrente = new ContaPJCorrente(numConta+"-21", saldoInicial);
            case INVESTIMENTO -> contaPJInvestimento = new ContaPJInvestimento(numConta+"-22", saldoInicial);
        }
    }

    public TipoContaPJ getTipoDeConta() {
        return tipoContaPJ;
    }

    @Override
    public String getNumConta(TipoConta tipoConta) {
        String conta = null;
        switch (tipoConta){
            case CORRENTE -> conta = contaPJCorrente.numConta;
            case INVESTIMENTO ->  conta = contaPJInvestimento.numConta;
        }
        return conta;
    }
}
