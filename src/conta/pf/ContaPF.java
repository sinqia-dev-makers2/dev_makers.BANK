package conta.pf;

import conta.modelos.Conta;
import conta.modelos.TipoConta;

public class ContaPF extends Conta {
    TipoContaPF tipoContaPF;
    public ContaPFCorrente contaPFCorrente;
    public ContaPFPoupanca contaPFPoupanca;
    public ContaPFInvestimento contaPFInvestimento;
    
    protected ContaPF(String numConta) {
        super(numConta + "-1");
        txRendimento = 1.000;
        txTransferencia = 1.000;
        txSaque = 1.000;
    }
    
    @Override
    public void criarConta(TipoConta tipoConta, String idCliente) {
        String numConta = idCliente;
        double saldoInicial = 0;
        switch (tipoConta) {
            case CORRENTE -> contaPFCorrente = new ContaPFCorrente(numConta+"-11", saldoInicial);
            case POUPANCA -> contaPFPoupanca = new ContaPFPoupanca(numConta+"-12", saldoInicial);
            case INVESTIMENTO -> contaPFInvestimento = new ContaPFInvestimento(numConta+"-13", saldoInicial);
        }
    }
    
    public TipoContaPF getTipoDeConta() {
        return tipoContaPF;
    }

    @Override
    public String getNumConta(TipoConta tipoConta) {
        String conta = null;
        switch (tipoConta){
            case CORRENTE -> conta = contaPFCorrente.numConta;
            case POUPANCA -> conta = contaPFPoupanca.numConta;
            case INVESTIMENTO ->  conta = contaPFInvestimento.numConta;
        }
        return conta;
    }
}
