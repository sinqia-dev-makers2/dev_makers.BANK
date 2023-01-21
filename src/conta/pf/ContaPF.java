package conta.pf;

import conta.modelos.Conta;
import conta.modelos.TipoConta;

public class ContaPF extends Conta {
    TipoContaPF tipoContaPF;
    
    protected ContaPF(String numConta) {
        super(numConta + "-1");
        txRendimento = 1.000;
        txTransferencia = 1.000;
        txSaque = 1.000;
    }
    
    @Override
    public void criarConta(TipoConta tipoConta) {
        String numConta = "1001"; // a definir ainda
        double saldoInicial = 0;
        switch (tipoConta) {
            case CORRENTE -> new ContaPFCorrente(numConta, saldoInicial);
            case POUPANCA -> new ContaPFPoupanca(numConta, saldoInicial);
            case INVESTIMENTO -> new ContaPFInvestimento(numConta, saldoInicial);
        }
    }
    
    public TipoContaPF getTipoDeConta() {
        return tipoContaPF;
    }
    
}
