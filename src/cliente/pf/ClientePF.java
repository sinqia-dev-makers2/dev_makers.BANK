package cliente.pf;

import cliente.modelos.Cliente;
import cliente.modelos.TipoDeCliente;
import cliente.modelos.TipoIDCliente;
import conta.modelos.TipoConta;

public class ClientePF extends Cliente{
    TipoDeCliente tipoDeCliente = TipoDeCliente.FISICA;
    TipoIDCliente tipoIDCliente = TipoIDCliente.CPF;
    
    public ClientePF(String nomeDoCliente) {
        super(nomeDoCliente);
    }
    
    @Override
    public void abrirConta(TipoConta tipoConta) {
        contaDoCliente.criarConta(tipoConta);
    }
    
    
}
