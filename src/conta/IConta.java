package conta;

public interface IConta<T> {
    double getSaldo();
    void atualizarSaldo(double valor);
    void receberTransferencia(double valor);
    void enviarTransferencia(T ContaDestino,double valor);
}
