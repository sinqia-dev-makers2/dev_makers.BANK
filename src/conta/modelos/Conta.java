package conta.modelos;

public abstract class Conta implements IConta<Conta, TipoConta>{
    private String numConta;
    protected double saldo;
    public double txRendimento;
    public double txTransferencia;
    public double txSaque;
    
    protected Conta(String numConta) {
        this.numConta = numConta;
    }
    
    public String getNumConta() {
        return numConta;
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
        setSaldo(getSaldo() + valor);
    }
    
    @Override
    public void receberDeposito(double valor) {
        setSaldo(getSaldo() + valor * (1 + txRendimento));
    }
    
    public void enviarTransferencia(Conta contaDestino, double valor) {
        setSaldo(getSaldo() - valor * (1 + txTransferencia));
        contaDestino.receberTransferencia(valor);
    }
    
    @Override
    public void sacarDaConta(double valor) {
        setSaldo(getSaldo() - valor * (1 + txSaque));
    }
    
}
