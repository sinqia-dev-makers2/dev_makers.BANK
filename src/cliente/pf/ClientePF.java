package cliente.pf;

import cliente.modelos.Cliente;
import cliente.modelos.TipoDeCliente;

public class ClientePF extends Cliente{
    TipoDeCliente tipoDeCliente = TipoDeCliente.FISICA;
    
    public ClientePF(String nomeDoCliente) {
        super(nomeDoCliente);
    }
    
}
