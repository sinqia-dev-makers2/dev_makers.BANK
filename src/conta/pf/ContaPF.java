package conta.pf;

import conta.modelos.Conta;
import conta.modelos.TipoConta;

public class ContaPF extends Conta {
	
    public ContaPF(String numConta) {
        super(numConta);
        txTransferencia = 1;
        txSaque = 1;
        txPoupanca = 1.010;
        txInvestimento = 1.015;
        saldo = 0.0;
    }

    @Override
    public void criarConta(TipoConta tipoConta, String idCliente) {
        switch (tipoConta) {
            case PF_CORRENTE -> {
            	contasMAP.put("11", new ContaPF(idCliente));
            	contasMAP.get("11").tipoConta = TipoConta.PF_CORRENTE;
            }
            case PF_POUPANCA -> {
            	contasMAP.put("12", new ContaPF(idCliente));
            	contasMAP.get("12").tipoConta = TipoConta.PF_POUPANCA;
            }
            case PF_INVESTIMENTO -> {
            	contasMAP.put("13", new ContaPF(idCliente));
            	contasMAP.get("13").tipoConta = TipoConta.PF_INVESTIMENTO;
            }
            default -> System.out.print("");
        }
    }
    
    @Override
    public TipoConta getTipoConta() {
        return this.tipoConta;
    }

}