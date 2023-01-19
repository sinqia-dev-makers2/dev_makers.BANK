package interfaces;

import conta.Conta;
import enumeraveis.TipoDeConta;

public interface IPessoa<T extends Conta, S extends TipoDeConta>{
    void abrirConta(S tipoDeConta);
    
    void sacar(T conta, double valor);

    void depositar(T conta, double valor);

    void transferir(T contaOrigem, T contaDestino, double valor);

    double consultarSaldo(T conta);
}
