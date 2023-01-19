package conta;

public abstract class Conta implements IConta {
    private String numConta;
    private TipoDeConta tipoDeConta;
    private double saldo;
    
    public Conta(String numConta, TipoDeConta tipoDeConta) {
        this.numConta = numConta;
        this.tipoDeConta = tipoDeConta;
    }
    
    public String getNumConta() {
        return numConta;
    }
    public TipoDeConta getTipoDeConta() {
        return tipoDeConta;
    }
    
    public double consultarSaldo() {
        return saldo;
    }
    public void atualizarSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void depositar(double valorRecebido) {
        atualizarSaldo(consultarSaldo() + valorRecebido);
    }
    public void retirar(double valorRetirado) {
        atualizarSaldo(consultarSaldo() - valorRetirado);
    }
    
    public void receberTransferencia(double valorReceber) {
        depositar(valorReceber);
    }
    public void enviarTransferencia(double valorEnviar) {
        retirar(valorEnviar);
    }
}
