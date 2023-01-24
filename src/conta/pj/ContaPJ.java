package conta.pj;

import conta.modelos.Conta;
import conta.modelos.TipoConta;
import conta.pf.ContaPF;

import java.util.HashMap;
import java.util.Map;

public class ContaPJ extends Conta {
    TipoConta tipoContaPJ;
    Map<String, ContaPJ> contasMAP = new HashMap<>();
    
    protected ContaPJ(String numConta) {
        super(numConta);
        txTransferencia = 1.005;
        txSaque = 1.005;
        txInvestimento = 1.035;
        saldo = 0.0;
    }
    
    @Override
    public void criarConta(TipoConta tipoConta, String idCliente) {
        String numConta = idCliente;
        double saldoInicial = 0;
        switch (tipoConta) {
            case PJ_CORRENTE -> contasMAP.put("21", new ContaPJ(numConta + "-21"));
            case PJ_INVESTIMENTO -> contasMAP.put("23", new ContaPJ(numConta + "-23"));
        }
    }

    public TipoConta getTipoDeConta() {
        return tipoContaPJ;
    }

//    @Override
//    public String getNumConta(TipoConta tipoConta) {
//        String conta = null;
//        switch (tipoConta){
//            case PJ_CORRENTE -> conta = contaPJCorrente.numConta;
//            case PJ_INVESTIMENTO ->  conta = contaPJInvestimento.numConta;
//        }
//        return conta;
//    }
}
