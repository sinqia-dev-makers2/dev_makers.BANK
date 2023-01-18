public abstract class Conta implements IConta{
    private String agencia;
    private String conta;
    private String senha;
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
