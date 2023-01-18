public interface IConta<T extends Conta> {
    void sacar(T t, double valor);

    void depositar(T t,double valor);

    void transferir(T tOrigem, T tDestino, double valor);

    double consultarSaldo(T t);
}
