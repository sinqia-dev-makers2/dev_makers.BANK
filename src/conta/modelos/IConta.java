package conta.modelos;

public interface IConta<T extends Conta> {
    double getSaldo();
    void atualizarSaldo(double valor);
    void receberTransferencia(double valor);
    void receberDeposito(double valor);
    void enviarTransferencia(T contaDestino,double valor);
    void sacarDaConta(double valor);

}
