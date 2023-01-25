package aplicacao;

import cliente.modelos.Cliente;
import cliente.modelos.TipoCliente;
import cliente.modelos.TipoDoc;
import conta.modelos.TipoConta;

import java.util.*;

public class Banco {
    Scanner sc = new Scanner(System.in);
    Map<String, Cliente> clientesMAP = new HashMap<>();
//    public int numClientesTotal = Cliente.totalClientes; // acessando o atributo static usado como contador
    public int numClientesPF = 0; // precisamos considerar quantos clientes PF foram adicionados via carregarBD() e somar!
    public int numClientesPJ = 0; // precisamos considerar quantos clientes PJ foram adicionados via carregarBD() e somar!

    public void iniciar() {
        // MENU INICIAL DO BANCO
        // poderia carregar clientes e contas préviamente cadastrados agora
//        carregarBD(); // poderia até ser uma opção oculta, que não estaria descrita no MENU, opção 0?
        cadastrarCliente(); // opçao 1
//        logarClient(); // opçao 2
//        depositar(); // opçao 3
//        fecharAplicacao(); // opcao X
    }

    public void cadastrarCliente() {
        TipoCliente tipoCliente = getTipoDeCliente();
        String nomeDoCliente = getNomeCliente();
        TipoDoc tipoDoc = getTipoDoc(tipoCliente);
        String docCliente = getDocCliente(tipoCliente);
        Cliente cliente = new Cliente(tipoCliente, nomeDoCliente, tipoDoc, docCliente, criarID(tipoCliente));
        cliente.cadastrarSenha("escreva sua senha amigo :D");
        switch (tipoCliente) {
            case FISICA -> numClientesPF++;
            case JURIDICA -> numClientesPJ++;
        }
        cadastrarConta(cliente, cliente.escolherConta(cliente.tipoCliente));
        clientesMAP.put(cliente.contaDoCliente.numConta, cliente);
    }

    private TipoCliente getTipoDeCliente() {
        System.out.print("\n Informe o tipo de cliente:\n 1 - PF (Pessoa Física)\n 2 - PJ (Pessoa Jurídica)");
        int inputTipoCliente = sc.nextInt();
        sc.nextLine();
        return TipoCliente.getTipoCliente(inputTipoCliente);
    }

    private String getNomeCliente() {
        System.out.println(" Digite o nome do cliente:");
        return sc.nextLine();
    }
    
    private TipoDoc getTipoDoc(TipoCliente tipoCliente){
        return TipoCliente.getTipoDoc(tipoCliente);
    }

//    private TipoDocCliente getTipoDoc(TipoCliente tipoCliente) {
//        TipoDocCliente tipoDocCliente = null;
//        switch (tipoCliente) {
//            case FISICA -> tipoDocCliente = TipoDocCliente.CPF;
//            case JURIDICA -> tipoDocCliente = TipoDocCliente.CNPJ;
//        }
//        return tipoDocCliente;
//    }

    private String getDocCliente(TipoCliente tipoCliente) {
        switch (tipoCliente) {
            case FISICA -> System.out.println("Digite o CPF do cliente:");
            case JURIDICA -> System.out.println("Digite o CNPJ do cliente:");
        }
        return sc.nextLine();
    }

    public void cadastrarConta(Cliente cliente, TipoConta tipoConta) {
        cliente.abrirConta(tipoConta, cliente.numIDCliente);
    }

    public String criarID(TipoCliente tipoCliente) {
        int idCliente = 0;
        switch (tipoCliente) {
            case FISICA -> idCliente = 1000000 + parcialID() + (numClientesPF + 1);
            case JURIDICA -> idCliente = 2000000 + parcialID() + (numClientesPJ + 1);
        }
        /*
            ex: se já exixtem 142 clientes no banco, sendo 77 pessoa fisica, teremos:
                1.000.000 + (1.000 * (142 + 1)) + (77 + 1) =
                1.000.000 + (1.000 * (143))     + (78)     =
                1.000.000 + (143.000)           + (78)     = 1.143.078 <- clienteID
        */
        return String.valueOf(idCliente); // ex: "1143078" ou "2458189"
    }

    private int parcialID() {
        return (1000 * (clientesMAP.size() + 1));
    }

    private Cliente buscarConta(String numConta) {
        if (clientesMAP.get(numConta) != null) {
            return clientesMAP.get(numConta);
        } else {
            System.out.println("Cliente não encontrado.");
            return null;
        }
    }
}
