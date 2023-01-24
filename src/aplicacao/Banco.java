package aplicacao;

import cliente.modelos.Cliente;
import cliente.modelos.TipoDeCliente;
import cliente.modelos.TipoDocCliente;
import conta.modelos.TipoConta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
    Scanner sc = new Scanner(System.in);
    
    List<Cliente> clientes = new ArrayList<>();
    public int numClientes = 0;
    public int numClientesPF = 0;
    public int numClientesPJ = 0;

//    List<Cliente> clientesPF = new ArrayList<>();
//    List<Cliente> clientesPJ = new ArrayList<>();
    
    public void main() {
        cadastrarCliente();
    }
    
    public void cadastrarCliente(){
        TipoDeCliente tipoDeCliente = getTipoDeCliente();
        String nomeDoCliente = getNomeCliente();
        TipoDocCliente tipoDocCliente = getTipoDoc(tipoDeCliente);
        String docCliente = getDocCliente(tipoDeCliente);
        
        Cliente cliente = new Cliente(tipoDeCliente, nomeDoCliente, tipoDocCliente, docCliente, criarID(tipoDeCliente));
        
        cliente.cadastrarSenha("escreva sua senha amigo :D");
        
        clientes.add(cliente);
        
        switch (tipoDeCliente) {
            case FISICA -> numClientesPF++;
            case JURIDICA -> numClientesPJ++;
        }
        numClientes++;
        
        cadastrarConta(cliente, cliente.escolherConta(cliente.tipoDeCliente));
    }
    
    private TipoDeCliente getTipoDeCliente() {
        TipoDeCliente tipoDeCliente = null;
        System.out.printf("\n Informe o tipo de cliente:\n 1 - PF (Pessoa Física)\n 2 - PJ (Pessoa Jurídica)");
        int inputTipoCliente = sc.nextInt();
        sc.nextLine();
        switch (inputTipoCliente) {
            case 1: tipoDeCliente = TipoDeCliente.FISICA;
            case 2: tipoDeCliente = TipoDeCliente.JURIDICA;
        }
        return tipoDeCliente;
    }
    
    private String getNomeCliente() {
        System.out.println(" Digite o nome do cliente:");
        String nomeDoCliente = sc.nextLine();
        return nomeDoCliente;
    }
    
    private TipoDocCliente getTipoDoc(TipoDeCliente tipoDeCliente) {
        TipoDocCliente tipoDocCliente = null;
        switch (tipoDeCliente) {
            case FISICA -> tipoDocCliente = TipoDocCliente.CPF;
            case JURIDICA -> tipoDocCliente = TipoDocCliente.CNPJ;
        }
        return tipoDocCliente;
    }
    
    private String getDocCliente(TipoDeCliente tipoDeCliente) {
        String docCliente = null;
        switch (tipoDeCliente) {
            case FISICA -> {
                System.out.println("Digite o CPF do cliente:");
                String cpf = sc.nextLine();
                docCliente = cpf;
            }
            case JURIDICA -> {
                System.out.println("Digite o CNPJ do cliente:");
                String cnpj = sc.nextLine();
                docCliente = cnpj;
            }
        }
        return docCliente;
    }
    
    public void cadastrarConta(Cliente cliente, TipoConta tipoConta){
        cliente.abrirConta(tipoConta, cliente.numIDCliente);
    }

    public String criarID(TipoDeCliente tipoDeCliente){
        int idCliente = 0;
        switch (tipoDeCliente){
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
    
    private int parcialID(){
        return (1000 * (numClientes + 1));
    }
}
