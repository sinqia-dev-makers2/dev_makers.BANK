package cliente.modelos;

import conta.modelos.Conta;

public interface ICliente<T extends Conta>{
    
    double consultarSaldo(T conta);
    
    void depositar(T conta, double valor);
    
    void sacar(T conta, double valor);

    void transferir(T contaOrigem, T contaDestino, double valor);
}
