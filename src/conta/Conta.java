package conta;

import enumeraveis.TipoDeConta;

public class Conta {
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
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
