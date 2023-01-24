package conta.pj;

import conta.modelos.Conta;
import conta.modelos.TipoConta;

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
        switch (tipoConta) {
            case PJ_CORRENTE -> contasMAP.put("21", new ContaPJ(idCliente + "-21"));
            case PJ_INVESTIMENTO -> contasMAP.put("23", new ContaPJ(idCliente + "-23"));
        }
    }
    
//    @Override
//    public TipoConta getTipoConta(TipoConta tipoConta) {
//        return tipoContaPJ;
//    }

}