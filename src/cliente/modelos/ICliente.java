package cliente.modelos;

import conta.modelos.Conta;

public interface ICliente<T extends Conta, S>{
    
    double consultarSaldo(T conta);
    
    void depositar(T conta, double valor);
    
    boolean sacar(T conta, int valor);

    boolean transferir(T contaOrigem, T contaDestino, double valor);
    
    void abrirConta(S tipoConta, String idCliente);
    
    void cadastrarSenha(String senha);
    
    TipoCliente getTipoCliente();
    
}
