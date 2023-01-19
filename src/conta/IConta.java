package conta;

public interface IConta {
    double consultarSaldo();
    void atualizarSaldo(double valor);
    void receberTransferencia(double valor);
    void enviarTransferencia(double valor);
}
