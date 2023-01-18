package interfaces;

import conta.Conta;

public interface IPessoa<T extends Conta>{
    void sacar(T conta, double valor);

    void depositar(T conta, double valor);

    void transferir(T contaOrigem, T contaDestino, double valor);

    double consultarSaldo(T conta);
}
