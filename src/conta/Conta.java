package conta;

public abstract class Conta {
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

    public double getSaldo() {
        return saldo;
    }
}
