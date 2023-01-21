package aplicacao;

import cliente.modelos.Cliente;
import cliente.modelos.TipoDeCliente;
import cliente.pf.ClientePF;
import cliente.pj.ClientePJ;
import conta.modelos.TipoConta;
import conta.pf.ContaPF;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    List<ClientePF> clientesPF = new ArrayList<>();

    List<ClientePJ> clientesPJ = new ArrayList<>();

    public void cadastrarCliente(TipoDeCliente tipoDeCliente){
        Cliente cliente = null;
        switch (tipoDeCliente){
            case FISICA -> {cliente = new ClientePF("Felipe", criarID(tipoDeCliente));
                cliente.cadastrarSenha("escreva sua senha amigo :D");
                cadastrarConta(cliente, TipoConta.CORRENTE); //criar variavel para o tipo da conta
                clientesPF.add((ClientePF) cliente);
            }
            case JURIDICA -> {cliente = new ClientePJ("FelipeSA", criarID(tipoDeCliente));
                cliente.cadastrarSenha("escreva sua senha amigo :D");
                cadastrarConta(cliente, TipoConta.CORRENTE); //criar variavel para o tipo da conta
                clientesPJ.add((ClientePJ) cliente);
            }
        }
    }

    public void cadastrarConta(Cliente cliente, TipoConta tipoConta){
        cliente.abrirConta(tipoConta, cliente.numIDCliente);
    }

    public String criarID(TipoDeCliente tipoDeCliente){
        int idCliente = 0;
        switch (tipoDeCliente){
            case FISICA -> idCliente = clientesPF.size()+1;
            case JURIDICA -> idCliente = clientesPJ.size()+1;
        }
        return String.valueOf(idCliente);
    }
}
