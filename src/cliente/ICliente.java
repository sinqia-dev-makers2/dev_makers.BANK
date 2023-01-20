package cliente;

import conta.Conta;
import conta.TipoDeConta;

public interface ICliente<T>{
    
    double consultarSaldo();
    
    void depositar(double valor);
    
    void sacar(double valor);

    void transferir(T contaOrigem, T contaDestino, double valor);
}
