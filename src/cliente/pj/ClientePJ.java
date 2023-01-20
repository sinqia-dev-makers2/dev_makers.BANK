package cliente.pj;

import cliente.modelos.Cliente;
import cliente.modelos.TipoDeCliente;

public class ClientePJ extends Cliente {
    TipoDeCliente tipoDeCliente = TipoDeCliente.JURIDICA;
    
    public ClientePJ(String nomeDoCliente) {
        super(nomeDoCliente);
    }
}