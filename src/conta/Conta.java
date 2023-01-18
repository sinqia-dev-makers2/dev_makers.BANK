package conta;

import enumeraveis.TipoDeConta;

public class Conta {
    private String numConta;
    private String senha;
    private TipoDeConta tipoDeConta;
    private double saldo;

    public Conta(String numConta, String senha, TipoDeConta tipoDeConta, double saldo) {
        this.numConta = numConta;
        this.senha = senha;
        this.tipoDeConta = tipoDeConta;
        this.saldo = saldo;
    }

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoDeConta getTipoDeConta() {
        return tipoDeConta;
    }

    public void setTipoDeConta(TipoDeConta tipoDeConta) {
        this.tipoDeConta = tipoDeConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
