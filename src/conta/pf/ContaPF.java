package conta.pf;

import conta.modelos.Conta;
import conta.modelos.TipoConta;

import java.util.HashMap;
import java.util.Map;

public class ContaPF extends Conta {
    public double txPoupanca;
    TipoConta tipoContaPF;
    Map<String, ContaPF> contasMAP = new HashMap<>();

    protected ContaPF(String numConta) {
        super(numConta);
        txTransferencia = 1.000;
        txSaque = 1.000;
        txPoupanca = 1.010;
        txInvestimento = 1.015;
        saldo = 0.0;
    }

    @Override
    public void criarConta(TipoConta tipoConta, String idCliente) {
        String numConta = idCliente;
        switch (tipoConta) {
            case PF_CORRENTE -> contasMAP.put("11", new ContaPF(numConta + "-11"));
            case PF_POUPANCA -> contasMAP.put("12", new ContaPF(numConta + "-12"));
            case PF_INVESTIMENTO -> contasMAP.put("13", new ContaPF(numConta + "-13"));
        }
    }

    public TipoConta getTipoDeConta() {
        return tipoContaPF;
    }

//    @Override
//    public String getNumConta(TipoConta tipoConta) {
//        String conta = null;
//        switch (tipoConta) {
//            case PF_CORRENTE -> conta = contaPFCorrente.numConta;
//            case PF_POUPANCA -> conta = contaPFPoupanca.numConta;
//            case PF_INVESTIMENTO -> conta = contaPFInvestimento.numConta;
//        }
//        return conta;
//    }
}
