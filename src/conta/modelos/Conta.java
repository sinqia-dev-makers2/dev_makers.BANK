package conta.modelos;

import conta.pf.ContaPFCorrente;
import conta.pf.ContaPFInvestimento;
import conta.pf.ContaPFPoupanca;
import conta.pj.ContaPJCorrente;
import conta.pj.ContaPJInvestimento;

public abstract class Conta implements IConta<Conta, TipoConta>{
    public String numConta;
    protected double saldo;
    public double txRendimento;
    public double txTransferencia;
    public double txSaque;
    protected Conta(String numConta) {
        this.numConta = numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void atualizarSaldo(double valor) {
        setSaldo(valor);
    }
    
    public void receberTransferencia(double valor) {
        atualizarSaldo(getSaldo() + valor);
    }
    
    @Override
    public void receberDeposito(double valor) {
        atualizarSaldo(getSaldo() + valor * (txRendimento));
    }
    
    public void enviarTransferencia(Conta contaDestino, double valor) {
        atualizarSaldo(getSaldo() - valor * (txTransferencia));
        contaDestino.receberTransferencia(valor);
    }
    
    @Override
    public void sacarDaConta(double valor) {
        atualizarSaldo(getSaldo() - valor * (txSaque));
    }

    public abstract void criarConta(TipoConta tipoConta, String idCliente);

    public abstract String getNumConta(TipoConta tipoConta);

}
