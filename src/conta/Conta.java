package conta;

public abstract class Conta {
    private String numConta;
    private double saldo;
    
    public Conta(String numConta) {
        this.numConta = numConta;
    }
    
    public String getNumConta() {
        return numConta;
    }


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
