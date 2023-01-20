package cliente.modelos;

import conta.modelos.Conta;
import conta.modelos.TipoConta;

public interface ICliente<T extends Conta, S extends TipoConta>{
    
    double consultarSaldo(T conta);
    
    void depositar(T conta, double valor);
    
    void sacar(T conta, double valor);

    void transferir(T contaOrigem, T contaDestino, double valor);
    
    void abrirConta(S tipoConta);
    
    
}
