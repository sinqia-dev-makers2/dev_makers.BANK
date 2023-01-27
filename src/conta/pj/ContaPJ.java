package conta.pj;

import conta.modelos.Conta;
import conta.modelos.TipoConta;

public class ContaPJ extends Conta {
    
    public ContaPJ(String numConta) {
        super(numConta);
        txTransferencia = 1.005;
        txSaque = 1.005;
        txInvestimento = 1.035;
        saldo = 0.0;
    }
    
    @Override
    public void criarConta(TipoConta tipoConta, String idCliente) {
        switch (tipoConta) {
            case PJ_CORRENTE -> {
            	contasMAP.put("21", new ContaPJ(idCliente));
            	contasMAP.get("21").tipoConta = TipoConta.PJ_CORRENTE;
            }
            case PJ_INVESTIMENTO -> {
            	contasMAP.put("23", new ContaPJ(idCliente));
            	contasMAP.get("23").tipoConta = TipoConta.PJ_INVESTIMENTO;
            }
            default -> System.out.print("");
        }
    }
    
    @Override
    public TipoConta getTipoConta() {
        return this.tipoConta;
    }

}