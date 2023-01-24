package conta.modelos;

public abstract class Conta implements IConta<Conta, TipoConta>{
    public String numConta;
    protected double saldo;
    public double txInvestimento;
    public double txTransferencia;
    public double txSaque;
    public Conta(String numConta) {
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
        atualizarSaldo(getSaldo() + valor * (txInvestimento));
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

    //public abstract String getNumConta(TipoConta tipoConta);

}
