package cliente.pj;

import cliente.modelos.Cliente;
import cliente.modelos.TipoDeCliente;
import cliente.modelos.TipoIDCliente;
import conta.modelos.TipoConta;


public class ClientePJ extends Cliente {
    TipoDeCliente tipoDeCliente = TipoDeCliente.JURIDICA;
    TipoIDCliente tipoIDCliente = TipoIDCliente.CNPJ;
    
    public ClientePJ(String nomeDoCliente, String numID) {
        super(nomeDoCliente, numID);
    }
}