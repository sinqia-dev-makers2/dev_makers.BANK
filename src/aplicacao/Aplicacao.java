package aplicacao;

import cliente.modelos.Cliente;
import cliente.pf.ClientePF;
import conta.modelos.Conta;
import conta.modelos.TipoConta;
import conta.pf.ContaPFCorrente;
import conta.pf.TipoContaPF;

public class Aplicacao {
    public static void main(String[] args) {
        Cliente leo = new ClientePF("Leonardo Oliveira Faria");
//        Conta leoContaCorrenta = new ContaPFCorrente("", 0);
        leo.contaDoCliente.criarConta(TipoConta.CORRENTE);

    }
}
