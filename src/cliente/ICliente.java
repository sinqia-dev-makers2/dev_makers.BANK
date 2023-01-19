package cliente;

import conta.Conta;
import conta.TipoDeConta;

public interface ICliente<T extends Conta, S extends TipoDeConta>{
    void abrirConta(S tipoDeConta);
    
    double consultarSaldo();
    
    void depositar(double valor);
    
    void sacar(double valor);

    void transferir(T contaDestino, double valor);
}
