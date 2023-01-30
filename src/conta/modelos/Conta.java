package conta.modelos;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static java.text.NumberFormat.getCurrencyInstance;

public abstract class Conta implements IConta<Conta, TipoConta>{
    public String numConta;
    public TipoConta tipoConta;
    protected double saldo;
    public double txPoupanca;
    public double txInvestimento;
    public double txTransferencia;
    public double txSaque;
    
    public Map<String, Conta> contasMAP = new HashMap<>();
    
    public Conta(String numConta) {
        this.numConta = numConta;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public String getSaldoFormatado() {
    	return getCurrencyInstance(new Locale("pt", "BR")).format(getSaldo());
    }
    
    public void atualizarSaldo(double valor) {
        this.saldo = valor;
    }
    
    public void receberTransferencia(double valor) {
        atualizarSaldo(getSaldo() + valor);
    }
    
    @Override
    public void receberDeposito(TipoConta tipoConta, double valor) {
    	if(tipoConta == TipoConta.PF_INVESTIMENTO || tipoConta == TipoConta.PJ_INVESTIMENTO) {
    		atualizarSaldo(getSaldo() + (valor * txInvestimento));
    	}
    	else if(tipoConta == TipoConta.PF_POUPANCA) {
    		atualizarSaldo(getSaldo() + (valor * txPoupanca));
    	}
    	else{
    		atualizarSaldo(getSaldo() + valor);
    	}
        
    }
    
    public void enviarTransferencia(Conta numContaDestino, double valor) {
        atualizarSaldo(getSaldo() - valor * (txTransferencia));
        numContaDestino.receberTransferencia(valor);
    }
    
    @Override
    public void sacarDaConta(double valor) {
        atualizarSaldo(getSaldo() - valor * (txSaque));
    }

    public abstract void criarConta(TipoConta tipoConta, String idCliente);

    public abstract TipoConta getTipoConta();

}
