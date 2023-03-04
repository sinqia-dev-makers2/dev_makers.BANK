package aplicacao;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import cliente.modelos.Cliente;
import cliente.modelos.TipoCliente;
import cliente.modelos.TipoDoc;
import conta.modelos.TipoConta;
import utilitarios.Formatar_CPF_CNPJ;
import utilitarios.LeitorDeDados;

public class Banco {

    LeitorDeDados leitor = new LeitorDeDados();
    Formatar_CPF_CNPJ formatar = new Formatar_CPF_CNPJ();
    Map<String, Cliente> clientesMAP = new HashMap<>();

    public int numClientesPF = 0; // precisamos considerar quantos clientes PF foram adicionados via carregarBD() e somar!
    public int numClientesPJ = 0; // precisamos considerar quantos clientes PJ foram adicionados via carregarBD() e somar!

    Cliente clienteAux;
    TipoConta tipoAux;
    String contaAux;
    String senhaAux;

    public void iniciar() throws ParseException, InterruptedException {
        carregaDadosPrevios();
        menuInicio();
    }


    public void carregaDadosPrevios() {
        TipoCliente tipoCliente = TipoCliente.FISICA;
        String nomeDoCliente = "Matheus";
        TipoDoc tipoDoc = TipoDoc.CPF;
        String docCliente = "412.160.228-40";
        Cliente cliente = new Cliente(tipoCliente, nomeDoCliente, tipoDoc, docCliente, criarID(tipoCliente));
        cliente.cadastrarSenha("1234");
        switch (tipoCliente) {
            case FISICA -> numClientesPF++;
            case JURIDICA -> numClientesPJ++;
        }
        cliente.abrirConta(TipoConta.PF_CORRENTE, cliente.numIDCliente + "-11");
        clientesMAP.put(cliente.numIDCliente, cliente);
        System.out.println("\t >>>>>> Dados da Conta Criada");
        System.out.println("\t >>> Cliente: " + nomeDoCliente);
        System.out.println("\t >>> Conta: " + cliente.numIDCliente + "-11");

        tipoCliente = TipoCliente.FISICA;
        nomeDoCliente = "Felipe";
        tipoDoc = TipoDoc.CPF;
        docCliente = "410.150.268-30";
        cliente = new Cliente(tipoCliente, nomeDoCliente, tipoDoc, docCliente, criarID(tipoCliente));
        cliente.cadastrarSenha("12345");
        switch (tipoCliente) {
            case FISICA -> numClientesPF++;
            case JURIDICA -> numClientesPJ++;
        }
        cliente.abrirConta(TipoConta.PF_CORRENTE, cliente.numIDCliente + "-11");
        clientesMAP.put(cliente.numIDCliente, cliente);
        System.out.println("\t >>>>>> Dados da Conta Criada");
        System.out.println("\t >>> Cliente: " + nomeDoCliente);
        System.out.println("\t >>> Conta: " + cliente.numIDCliente + "-11");

        tipoCliente = TipoCliente.JURIDICA;
        nomeDoCliente = "Richard";
        tipoDoc = TipoDoc.CNPJ;
        docCliente = "32.523.953/0001-51";
        cliente = new Cliente(tipoCliente, nomeDoCliente, tipoDoc, docCliente, criarID(tipoCliente));
        cliente.cadastrarSenha("123456");
        switch (tipoCliente) {
            case FISICA -> numClientesPF++;
            case JURIDICA -> numClientesPJ++;
        }
        cliente.abrirConta(TipoConta.PJ_CORRENTE, cliente.numIDCliente + "-21");
        clientesMAP.put(cliente.numIDCliente, cliente);
        System.out.println("\t >>>>>> Dados da Conta Criada");
        System.out.println("\t >>> Cliente: " + nomeDoCliente);
        System.out.println("\t >>> Conta: " + cliente.numIDCliente + "-21");

        tipoCliente = TipoCliente.JURIDICA;
        nomeDoCliente = "Wesley";
        tipoDoc = TipoDoc.CNPJ;
        docCliente = "27.313.317/0002-93";
        cliente = new Cliente(tipoCliente, nomeDoCliente, tipoDoc, docCliente, criarID(tipoCliente));
        cliente.cadastrarSenha("1234567");
        switch (tipoCliente) {
            case FISICA -> numClientesPF++;
            case JURIDICA -> numClientesPJ++;
        }
        cliente.abrirConta(TipoConta.PJ_INVESTIMENTO, cliente.numIDCliente + "-23");
        clientesMAP.put(cliente.numIDCliente, cliente);
        System.out.println("\t >>>>>> Dados da Conta Criada");
        System.out.println("\t >>> Cliente: " + nomeDoCliente);
        System.out.println("\t >>> Conta: " + cliente.numIDCliente + "-23");

        tipoCliente = TipoCliente.FISICA;
        nomeDoCliente = "Leonardo";
        tipoDoc = TipoDoc.CPF;
        docCliente = "240.110.278-20";
        cliente = new Cliente(tipoCliente, nomeDoCliente, tipoDoc, docCliente, criarID(tipoCliente));
        cliente.cadastrarSenha("12345");
        switch (tipoCliente) {
            case FISICA -> numClientesPF++;
            case JURIDICA -> numClientesPJ++;
        }
        cliente.abrirConta(TipoConta.PF_POUPANCA, cliente.numIDCliente + "-12");
        clientesMAP.put(cliente.numIDCliente, cliente);
        System.out.println("\t >>>>>> Dados da Conta Criada");
        System.out.println("\t >>> Cliente: " + nomeDoCliente);
        System.out.println("\t >>> Conta: " + cliente.numIDCliente + "-12");

        tipoCliente = TipoCliente.FISICA;
        nomeDoCliente = "Jackson";
        tipoDoc = TipoDoc.CPF;
        docCliente = "140.310.971-70";
        cliente = new Cliente(tipoCliente, nomeDoCliente, tipoDoc, docCliente, criarID(tipoCliente));
        cliente.cadastrarSenha("12345");
        switch (tipoCliente) {
            case FISICA -> numClientesPF++;
            case JURIDICA -> numClientesPJ++;
        }
        cliente.abrirConta(TipoConta.PF_INVESTIMENTO, cliente.numIDCliente + "-13");
        clientesMAP.put(cliente.numIDCliente, cliente);
        System.out.println("\t >>>>>> Dados da Conta Criada");
        System.out.println("\t >>> Cliente: " + nomeDoCliente);
        System.out.println("\t >>> Conta: " + cliente.numIDCliente + "-13");
        limpaMenu();
    }

    public void cadastrarCliente() throws ParseException, InterruptedException {
        TipoCliente tipoCliente = getTipoDeCliente();
        String nomeDoCliente = getNomeCliente();
        TipoDoc tipoDoc = getTipoDoc(tipoCliente);
        String docCliente = getDocCliente(tipoCliente);
        Cliente cliente = new Cliente(tipoCliente, nomeDoCliente, tipoDoc, docCliente, criarID(tipoCliente));
        cadastrarSenha(cliente);
        switch (tipoCliente) {
            case FISICA -> numClientesPF++;
            case JURIDICA -> numClientesPJ++;
        }
        clientesMAP.put(cliente.numIDCliente, cliente);
        cadastrarConta(cliente, cliente.escolherConta(cliente.tipoCliente));
        System.out.println("\t >>>>>> Conta criada com sucesso! <<<<<<");
        System.out.println("\t >>>>>> Dados da Conta Criada");
        System.out.println("\t >>> Cliente: " + nomeDoCliente);
        System.out.println("\t >>> Conta: " + cliente.numIDCliente + "-" + (
                (tipoAux.toString().split("_")[1].equals("CORRENTE") && tipoCliente == TipoCliente.FISICA) ? "11" :
                        (tipoAux.toString().split("_")[1].equals("CORRENTE") && tipoCliente == TipoCliente.JURIDICA) ? "21" :
                                (tipoAux.toString().split("_")[1].equals("INVESTIMENTO") && tipoCliente == TipoCliente.FISICA) ? "13" :
                                        (tipoAux.toString().split("_")[1].equals("INVESTIMENTO") && tipoCliente == TipoCliente.JURIDICA) ? "23" : "12"));
        System.out.println("\t\t\t\t\t\t Voltando ao menu inicial!");
    }

    private TipoCliente getTipoDeCliente() {
        System.out.println("\t >>> Tipo de pessoa ");
        System.out.println("\t\t 1 - Fisica");
        System.out.println("\t\t 2 - Juridica");
        System.out.print("\t >>> Digite a opção desejada: ");
        int inputTipoCliente = leitor.lerInteiro("[1-2]", "Digite a opção desejada: ");
        return TipoCliente.getTipoCliente(inputTipoCliente);
    }

    private String getNomeCliente() {
        System.out.print("\t >>> Nome e Sobrenome: ");
        return leitor.lerTexto("", "Nome e Sobrenome: ");
    }

    private void cadastrarSenha(Cliente cliente) {
        System.out.print("\t >>> Digite sua senha (Min. 3 caracteres): ");
        cliente.cadastrarSenha(leitor.lerTexto("", "Digite sua senha (Min. 3 caracteres): "));
    }

    private TipoDoc getTipoDoc(TipoCliente tipoCliente) {
        return TipoCliente.getTipoDoc(tipoCliente);
    }

    private String getDocCliente(TipoCliente tipoCliente) throws ParseException {
        switch (tipoCliente) {
            case FISICA -> {
                System.out.print("\t >>> Digite seu CPF (Não use simbolos, apenas os números): ");
                return formatar.formatarString(leitor.lerTexto("\\d{11}", "Digite seu CPF (Não use simbolos, apenas os números): "), tipoCliente);
            }
            case JURIDICA -> {
                System.out.print("\t >>> Digite seu CNPJ (Não use simbolos, apenas os números): ");
                return formatar.formatarString(leitor.lerTexto("\\d{14}", "Digite seu CNPJ (Não use simbolos, apenas os números): "), tipoCliente);
            }
            default -> {
                return null;
            }
        }
    }

    public void cadastrarConta(Cliente cliente, TipoConta tipoConta) throws ParseException, InterruptedException {
        tipoAux = tipoConta;
        switch (tipoConta) {
            case PF_CORRENTE -> {
                if (clientesMAP.get(cliente.numIDCliente).contaDoCliente != null) {
                    if (clientesMAP.get(cliente.numIDCliente).contaDoCliente.contasMAP.get("11") == null) {
                        cliente.abrirConta(tipoConta, cliente.numIDCliente + "-11");
                        return;
                    }
                } else {
                    cliente.abrirConta(tipoConta, cliente.numIDCliente + "-11");
                    return;
                }
            }
            case PF_POUPANCA -> {
                if (clientesMAP.get(cliente.numIDCliente).contaDoCliente != null) {
                    if (clientesMAP.get(cliente.numIDCliente).contaDoCliente.contasMAP.get("12") == null) {
                        cliente.abrirConta(tipoConta, cliente.numIDCliente + "-12");
                        return;
                    }
                } else {
                    cliente.abrirConta(tipoConta, cliente.numIDCliente + "-12");
                    return;
                }
            }
            case PF_INVESTIMENTO -> {
                if (clientesMAP.get(cliente.numIDCliente).contaDoCliente != null) {
                    if (clientesMAP.get(cliente.numIDCliente).contaDoCliente.contasMAP.get("13") == null) {
                        cliente.abrirConta(tipoConta, cliente.numIDCliente + "-13");
                        return;
                    }
                } else {
                    cliente.abrirConta(tipoConta, cliente.numIDCliente + "-13");
                    return;
                }
            }
            case PJ_CORRENTE -> {
                if (clientesMAP.get(cliente.numIDCliente).contaDoCliente != null) {
                    if (clientesMAP.get(cliente.numIDCliente).contaDoCliente.contasMAP.get("21") == null) {
                        cliente.abrirConta(tipoConta, cliente.numIDCliente + "-21");
                        return;
                    }
                } else {
                    cliente.abrirConta(tipoConta, cliente.numIDCliente + "-21");
                    return;
                }
            }
            case PJ_INVESTIMENTO -> {
                if (clientesMAP.get(cliente.numIDCliente).contaDoCliente != null) {
                    if (clientesMAP.get(cliente.numIDCliente).contaDoCliente.contasMAP.get("23") == null) {
                        cliente.abrirConta(tipoConta, cliente.numIDCliente + "-23");
                        return;
                    }
                } else {
                    cliente.abrirConta(tipoConta, cliente.numIDCliente + "-23");
                    return;
                }
            }
        }
        System.out.println("\t\t\t\t\t\t Cliente já possui uma conta desse tipo aberta!");
        System.out.println("\t\t\t\t\t\t Voltando ao menu principal!");
        Thread.sleep(3000);
        menuClienteLogado(cliente, clienteAux.contaDoCliente.contasMAP.get(contaAux.split("-")[1]).tipoConta);
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
            System.out.println("\t\t\t\t\t\t Cliente não encontrado!");
            return null;
        }
    }

    // MENUS

    public void limpaMenu() {
        for (int i = 0; i < 20; i++) { /// Depois vou aumentar a quantidade de linhas para limpar a tela
            System.out.println();
        }
    }

    public void menuInicio() throws ParseException, InterruptedException {
        limpaMenu();
        System.out.println("\t************************************************************************************************************");
        System.out.println("\t*************************************** Bem-Vindo ao Banco DevMakers ***************************************");
        System.out.println("\t************************************************************************************************************");
        System.out.println("\t >>> 1 - Realizar um depósito");
        System.out.println("\t >>> 2 - Entrar em sua conta");
        System.out.println("\t >>> 3 - Abrir uma conta");
        System.out.println("\t >>> 4 - Finalizar");
        System.out.print("\n\t >>> Digite a opção desejada: ");

        switch (leitor.lerInteiro("[0-4]", "Digite a opção desejada: ")) {
            case 0 -> {
                carregaDadosPrevios();
                menuInicio();
            }
            case 1 -> {
                limpaMenu();
                menuDepositoSemLogin();
            }
            case 2 -> {
                limpaMenu();
                menuEntrarConta();
            }
            case 3 -> {
                limpaMenu();
                menuAbrirConta();
            }
            case 4 -> System.exit(0);
        }
    }

    public void menuDepositoSemLogin() throws ParseException, InterruptedException {
        System.out.println("\t************************************************************************************************************");
        System.out.println("\t*************************************** Bem-Vindo ao Banco DevMakers ***************************************");
        System.out.println("\t************************************************************************************************************");
        System.out.println("\t >>>>>> Siga as instruções abaixo para realizar um depósito <<<<<<");
        System.out.print("\t >>> Digite a conta que deseja depositar (Ex: 123-12): ");
        contaAux = leitor.lerTexto("(\\d{7})(-)(\\d{2})", "Digite a conta que deseja depositar (Ex: 123-12): ");

        if (buscarConta(contaAux.split("-")[0]) != null) {
            clienteAux = buscarConta(contaAux.split("-")[0]);
            System.out.println("\n\t >>>>>>Dados da Conta: ");
            System.out.println("\t >>> Nome: " + clienteAux.getNomeDoCliente());
            System.out.println("\t >>> Conta: " + clienteAux.contaDoCliente.contasMAP.get(contaAux.split("-")[1]).numConta);
            System.out.println("\n\t >>> Deseja continuar com o depósito? S (Sim) / N (Não)");
            System.out.print("\t >>> Opção: ");
            switch (leitor.lerCaracter("[snSN]", "Opção: ")) {
                case 's' -> {
                    System.out.print("\t >>> Digite o valor que deseja depositar (Somente valores inteiros, não aceitamos moedas): R$");
                    int valorDeposito = leitor.lerInteiro("\\d+", "Digite o valor que deseja depositar (Somente valores inteiros, não aceitamos moedas): R$");
                    clienteAux.depositar(clienteAux.contaDoCliente.contasMAP.get(contaAux.split("-")[1]), valorDeposito);
                    System.out.println("\t\t\t\t\t\t Depósito efetuado com sucesso!");
                    System.out.println("\t\t\t\t\t\t Voltando ao menu inicial!");
                    Thread.sleep(3000);
                    menuInicio();
                }
                case 'n' -> {
                    System.out.println("\t\t\t\t\t\t Voltando ao menu inicial!");
                    Thread.sleep(3000);
                    menuInicio();
                }
            }
        } else {
            System.out.println("\t\t\t\t\t\t Conta não encontrada!");
            System.out.println("\t\t\t\t\t\t Voltando ao menu inicial!");
            Thread.sleep(3000);
            menuInicio();
        }
    }

    public void menuEntrarConta() throws ParseException, InterruptedException {
        System.out.println("\t************************************************************************************************************");
        System.out.println("\t*************************************** Bem-Vindo ao Banco DevMakers ***************************************");
        System.out.println("\t************************************************************************************************************");
        System.out.println("\t >>> Entre na sua conta\n");
        System.out.print("\t >>> Conta (Ex: 123-12): ");
        contaAux = leitor.lerTexto("(\\d{7})(-)(\\d{2})", "Conta (Ex: 123-12): ");
        System.out.print("\t >>> Senha: ");
        senhaAux = leitor.lerTexto("", "Senha: ");

        if (buscarConta(contaAux.split("-")[0]) != null) {
            clienteAux = buscarConta(contaAux.split("-")[0]);
            if (Objects.requireNonNull(clienteAux).getSenha().equals(senhaAux)) {
                if (clienteAux.contaDoCliente.contasMAP.get(contaAux.split("-")[1]) != null) {
                    System.out.println("\t\t\t\t\t\t Logado com sucesso, você será redirecionado!");
                    Thread.sleep(3000);
                    menuClienteLogado(clienteAux, clienteAux.contaDoCliente.contasMAP.get(contaAux.split("-")[1]).tipoConta);
                } else {
                    System.out.println("\t\t\t\t\t\t Conta e/ou Senha incorretos!");
                    System.out.println("\t\t\t\t\t\t Voltando ao menu inicial!");
                    Thread.sleep(3000);
                    menuInicio();
                }
            } else {
                System.out.println("\t\t\t\t\t\t Conta e/ou Senha incorretos!");
                System.out.println("\t\t\t\t\t\t Voltando ao menu inicial!");
                Thread.sleep(3000);
                menuInicio();
            }
        } else {
            System.out.println("\t\t\t\t\t\t Voltando ao menu inicial!");
            Thread.sleep(3000);
            menuInicio();
        }
    }

    public void menuAbrirConta() throws ParseException, InterruptedException {
        System.out.println("\t************************************************************************************************************");
        System.out.println("\t*************************************** Bem-Vindo ao Banco DevMakers ***************************************");
        System.out.println("\t************************************************************************************************************");
        System.out.println("\t >>>>>> Siga as instruções abaixo para abrir uma conta <<<<<<\n");
        cadastrarCliente();
        Thread.sleep(3000);
        menuInicio();
    }

    public void menuClienteLogado(Cliente clienteLogado, TipoConta tipoContaSelecionado) throws ParseException, InterruptedException {
        limpaMenu();
        int opcao = -1;
        System.out.println("\t************************************************************************************************************");
        System.out.println("\t*************************************** Bem-Vindo ao Banco DevMakers ***************************************");
        System.out.println("\t************************************************************************************************************");
        System.out.println("\t >>>>>> Sr(a). " + clienteLogado.getNomeDoCliente());
        System.out.println("\t >>>>>> Pessoa " + clienteLogado.getTipoCliente());
        System.out.println("\t >>>>>> Conta " + clienteLogado.numIDCliente + "-" + clienteLogado.contaDoCliente.contasMAP.get(contaAux.split("-")[1]).numConta.split("-")[1] + " (" + tipoContaSelecionado.toString().split("_")[1] + ")");
        System.out.println("\t >>>>>> Saldo: " + clienteLogado.contaDoCliente.contasMAP.get(contaAux.split("-")[1]).getSaldoFormatado());
        System.out.println("\t************************************************************************************************************");
        switch (tipoContaSelecionado) {
            case PF_CORRENTE:
            case PJ_CORRENTE:
            case PF_POUPANCA:
                System.out.println("\t >>> Selecione uma das opções abaixo");
                System.out.println("\t\t 1 - Saque");
                System.out.println("\t\t 2 - Depositar");
                System.out.println("\t\t 3 - Transferir");
                System.out.println("\t\t 4 - Ver outras contas");
                System.out.println("\t\t 5 - Abrir nova conta");
                System.out.println("\t\t 6 - Sair da conta");
                System.out.print("\t >>> Digite a opção desejada: ");
                opcao = leitor.lerInteiro("[1-6]", "Digite a opção desejada: ");
                break;
            case PF_INVESTIMENTO:
            case PJ_INVESTIMENTO:
                System.out.println("\t >>> Selecione uma das opções abaixo");
                System.out.println("\t\t 1 - Saque");
                System.out.println("\t\t 2 - Investir");
                System.out.println("\t\t 3 - Transferir");
                System.out.println("\t\t 4 - Ver outras contas");
                System.out.println("\t\t 5 - Abrir nova conta");
                System.out.println("\t\t 6 - Sair da conta");
                System.out.print("\t >>> Digite a opção desejada: ");
                opcao = leitor.lerInteiro("[1-6]", "Digite a opção desejada: ");
                break;
            default:
                System.out.println(" ");
        }

        switch (opcao) {
            case 1 -> menuSacar(clienteLogado, tipoContaSelecionado);
            case 2 -> {
                if ((tipoContaSelecionado == TipoConta.PF_CORRENTE || tipoContaSelecionado == TipoConta.PJ_CORRENTE || tipoContaSelecionado == TipoConta.PF_POUPANCA)) {
                    menuDepositar(clienteLogado, tipoContaSelecionado);
                } else if (tipoContaSelecionado == TipoConta.PF_INVESTIMENTO || tipoContaSelecionado == TipoConta.PJ_INVESTIMENTO) {
                    menuInvestir(clienteLogado, tipoContaSelecionado);
                }
            }
            case 3 -> menuTransferir(clienteLogado, tipoContaSelecionado);
            case 4 -> menuVerContas(clienteLogado, tipoContaSelecionado);
            case 5 -> menuAbrirNovaConta(clienteLogado, tipoContaSelecionado);
            case 6 -> {
                System.out.println("\t\t\t\t\t\t Saindo da conta! Voltando ao menu inicial");
                Thread.sleep(1000);
                menuInicio();
            }
        }
    }

    public void menuSacar(Cliente clienteLogado, TipoConta tipoContaSelecionado) throws ParseException, InterruptedException {
        limpaMenu();
        System.out.println("\t************************************************************************************************************");
        System.out.println("\t*************************************** Bem-Vindo ao Banco DevMakers ***************************************");
        System.out.println("\t************************************************************************************************************");
        System.out.println("\t >>>>>> Siga as instruções abaixo para sacar <<<<<<\n");
        System.out.println("\t >>> O saque será realizado da sua conta : " + tipoContaSelecionado.toString().split("_")[1] + "\n");
        System.out.println("\t >>> Saldo atual da conta: " + clienteLogado.contaDoCliente.contasMAP.get(contaAux.split("-")[1]).getSaldoFormatado());
        System.out.print("\t >>> Valor do saque (Somente valores inteiros, não fornecemos moedas) (0 para cancelar): R$ ");
        int valorSaque = leitor.lerInteiro("\\d+", "Valor do saque (Somente valores inteiros, não fornecemos moedas) (0 para cancelar): R$ ");
        if (valorSaque > 0) {
            if (clienteLogado.sacar(clienteLogado.contaDoCliente.contasMAP.get(contaAux.split("-")[1]), valorSaque)) {
                System.out.println("\t >>>>>> Saque efetuado com sucesso!");
            } else {
                System.out.println("\t >>>>>> Saque não realizado, saldo insuficiente!");
            }
        } else {
            System.out.println("\t\t\t\t\t\t Operação cancelada!");
        }

        System.out.println("\t\t\t\t\t\t Voltando ao menu principal!");
        Thread.sleep(3000);
        menuClienteLogado(clienteLogado, tipoContaSelecionado);
    }

    public void menuDepositar(Cliente clienteLogado, TipoConta tipoContaSelecionado) throws ParseException, InterruptedException {
        limpaMenu();
        System.out.println("\t************************************************************************************************************");
        System.out.println("\t*************************************** Bem-Vindo ao Banco DevMakers ***************************************");
        System.out.println("\t************************************************************************************************************");
        System.out.println("\t >>>>>> Siga as instruções abaixo para depositar <<<<<<\n");
        System.out.println("\t >>> O depósito será realizado na sua conta : " + tipoContaSelecionado.toString().split("_")[1] + "\n");
        System.out.print("\t >>> Digite o valor que deseja depositar (Somente valores inteiros, não aceitamos moedas) (0 para cancelar): R$");
        int valorDeposito = leitor.lerInteiro("\\d+", "Digite o valor que deseja depositar (Somente valores inteiros, não aceitamos moedas) (0 para cancelar): R$");
        if (valorDeposito > 0) {
            clienteLogado.depositar(clienteLogado.contaDoCliente.contasMAP.get(contaAux.split("-")[1]), valorDeposito);
            System.out.println("\t\t\t\t\t\t Depósito efetuado com sucesso!");
        } else {
            System.out.println("\t\t\t\t\t\t Operação cancelada!");
        }

        System.out.println("\t\t\t\t\t\t Voltando ao menu principal!");
        Thread.sleep(3000);
        menuClienteLogado(clienteLogado, tipoContaSelecionado);
    }

    public void menuInvestir(Cliente clienteLogado, TipoConta tipoContaSelecionado) throws ParseException, InterruptedException {
        limpaMenu();
        System.out.println("\t************************************************************************************************************");
        System.out.println("\t*************************************** Bem-Vindo ao Banco DevMakers ***************************************");
        System.out.println("\t************************************************************************************************************");
        System.out.println("\t >>>>>> Siga as instruções abaixo para investir <<<<<<\n");
        System.out.println("\t >>> O investimento será realizado na sua conta : " + tipoContaSelecionado.toString().split("_")[1] + "\n");
        System.out.print("\t >>> Digite o valor que deseja investir (Somente valores inteiros, não aceitamos moedas) (0 para cancelar): R$");
        int valorInvestimento = leitor.lerInteiro("\\d+", "Digite o valor que deseja depositar (Somente valores inteiros, não aceitamos moedas) (0 para cancelar): R$");
        if (valorInvestimento > 0) {
            clienteLogado.depositar(clienteLogado.contaDoCliente.contasMAP.get(contaAux.split("-")[1]), valorInvestimento);
            System.out.println("\t\t\t\t\t\t Investimento efetuado com sucesso!");
        } else {
            System.out.println("\t\t\t\t\t\t Operação cancelada!");
        }
        System.out.println("\t\t\t\t\t\t Voltando ao menu principal!");
        Thread.sleep(3000);
        menuClienteLogado(clienteLogado, tipoContaSelecionado);
    }

    public void menuTransferir(Cliente clienteLogado, TipoConta tipoContaSelecionado) throws ParseException, InterruptedException {
        limpaMenu();
        System.out.println("\t************************************************************************************************************");
        System.out.println("\t*************************************** Bem-Vindo ao Banco DevMakers ***************************************");
        System.out.println("\t************************************************************************************************************");
        System.out.println("\t >>>>>> Siga as instruções abaixo para realizar a transferencia <<<<<<\n");
        System.out.print("\t >>> Digite a conta de destino (Somente contas corrente recebem transferencias (sufixo 11 / 21) / 0 para cancelar): ");
        String contaDestino = leitor.lerTexto("(\\d{7})(-[1-2]1)||(0)", "Digite a conta de destino (Somente contas corrente recebem transferencias (sufixo 11 / 21) / 0 para cancelar): ");
        if (!contaDestino.equals("0")) {
            if (buscarConta(contaDestino.split("-")[0]) != null) {
                if (buscarConta(contaDestino.split("-")[0]).contaDoCliente.contasMAP.get(contaDestino.split("-")[1]) != null) {
                    System.out.print("\t >>> Digite o valor que deseja transferir (Ex: 1 ou 1.1 ou 1.11) (0 para cancelar): R$");
                    double valorTransferencia = leitor.lerDecimal("^(\\d+(?:.\\d{1,2})?).*", "Digite o valor que deseja transferir (Ex: 1 ou 1.1 ou 1.11) (0 para cancelar): R$");
                    if (valorTransferencia > 0) {
                        if (clienteLogado.transferir(clienteLogado.contaDoCliente.contasMAP.get(contaAux.split("-")[1]), buscarConta(contaDestino.split("-")[0]).contaDoCliente.contasMAP.get(contaDestino.split("-")[1]), valorTransferencia)) {
                            System.out.println("\t >>>>>> Transferencia efetuada com sucesso!");
                        } else {
                            System.out.println("\t >>>>>> Transferencia não realizada, saldo insuficiente!");
                        }
                    } else {
                        System.out.println("\t\t\t\t\t\t Operação cancelada!");
                    }
                } else {
                    System.out.println("\t\t\t\t\t\t Conta de destino não existe!");
                }
            } else {
                System.out.println("\t\t\t\t\t\t Conta inexistente!");
            }
        } else {
            System.out.println("\t\t\t\t\t\t Operação cancelada!");
        }
        System.out.println("\t\t\t\t\t\t Voltando ao menu principal!");
        Thread.sleep(3000);
        menuClienteLogado(clienteLogado, tipoContaSelecionado);
    }

    public void menuVerContas(Cliente clienteLogado, TipoConta tipoContaSelecionado) throws ParseException, InterruptedException {
        limpaMenu();
        TipoConta tipoAux = null;
        char escolhaTipoConta;
        String contaEscolhidaAux = "";
        System.out.println("\t************************************************************************************************************");
        System.out.println("\t*************************************** Bem-Vindo ao Banco DevMakers ***************************************");
        System.out.println("\t************************************************************************************************************");
        System.out.println("\t >>>>>> Abaixo segue suas contas abertas no banco <<<<<<\n");
        int[] sufix = {11, 12, 13, 21, 23};
        for (int sufixoAux : sufix) {
            if (clienteLogado.contaDoCliente.contasMAP.get(String.valueOf(sufixoAux)) != null) {
                if (clienteLogado.getTipoCliente() == TipoCliente.FISICA) {
                    if (sufixoAux == 11) {
                        System.out.println("\t >>> Corrente: " + clienteLogado.numIDCliente + "-11");
                    } else if (sufixoAux == 12) {
                        System.out.println("\t >>> Poupança: " + clienteLogado.numIDCliente + "-12");
                    } else if (sufixoAux == 13) {
                        System.out.println("\t >>> Investimento: " + clienteLogado.numIDCliente + "-13");
                    }

                } else if (clienteLogado.getTipoCliente() == TipoCliente.JURIDICA) {
                    if (sufixoAux == 21) {
                        System.out.println("\t >>> Corrente: " + clienteLogado.numIDCliente + "-21");
                    } else if (sufixoAux == 23) {
                        System.out.println("\t >>> Investimento: " + clienteLogado.numIDCliente + "-23");
                    }
                }
            }
        }

        System.out.println("\n\t >>>>>> Deseja alterar a conta logada? (S)sim / (N)não");
        System.out.print("\t >>> Digite a opção: ");
        if (leitor.lerCaracter("[SsNn]", "Digite a opção: ") == 's') {
            if (clienteLogado.getTipoCliente() == TipoCliente.FISICA) {
                System.out.println("\n\t >>>>>> Escolha uma opção (Ex: C - Corrente, P - Poupança e I - Investimento)");
                System.out.print("\t >>> Digite a opção: ");
                escolhaTipoConta = leitor.lerCaracter("[CcPpIi]", "Digite a opção: ");
                switch (escolhaTipoConta) {
                    case 'c' -> {
                        tipoAux = TipoConta.PF_CORRENTE;
                        contaEscolhidaAux = clienteLogado.numIDCliente + "-11";
                    }
                    case 'p' -> {
                        tipoAux = TipoConta.PF_POUPANCA;
                        contaEscolhidaAux = clienteLogado.numIDCliente + "-12";
                    }
                    case 'i' -> {
                        tipoAux = TipoConta.PF_INVESTIMENTO;
                        contaEscolhidaAux = clienteLogado.numIDCliente + "-13";
                    }
                }
                if (contaAux.equals(contaEscolhidaAux)) {
                    System.out.println("\n\t >>>>>> A conta selecionada é a mesma utilizada atualmente!");
                    System.out.println("\t\t\t\t\t\t Voltando ao menu principal!");
                    Thread.sleep(3000);
                    menuClienteLogado(clienteLogado, tipoAux);
                } else {
                    if (clienteLogado.contaDoCliente.contasMAP.get(contaEscolhidaAux.split("-")[1]) != null) {
                        System.out.println("\n\t >>>>>> Conta selecionada com sucesso!");
                        System.out.println("\t\t\t\t\t\t Voltando ao menu principal!");
                        contaAux = contaEscolhidaAux;
                        Thread.sleep(3000);
                        menuClienteLogado(clienteLogado, tipoAux);
                    } else {
                        System.out.println("\n\t >>>>>> Você não possue uma conta desse tipo!");
                        System.out.println("\t\t\t\t\t\t Voltando ao menu principal!");
                        Thread.sleep(3000);
                        menuClienteLogado(clienteLogado, tipoContaSelecionado);
                    }
                }
            } else if (clienteLogado.getTipoCliente() == TipoCliente.JURIDICA) {
                System.out.println("\n\t >>>>>> Escolha uma opção (Ex: C - Corrente e I - Investimento)");
                System.out.print("\t >>> Digite a opção: ");
                escolhaTipoConta = leitor.lerCaracter("[CcIi]", "Digite a opção: ");
                switch (escolhaTipoConta) {
                    case 'c' -> {
                        tipoAux = TipoConta.PJ_CORRENTE;
                        contaEscolhidaAux = clienteLogado.numIDCliente + "-21";
                    }
                    case 'i' -> {
                        tipoAux = TipoConta.PJ_INVESTIMENTO;
                        contaEscolhidaAux = clienteLogado.numIDCliente + "-23";
                    }
                }
                if (contaAux.equals(contaEscolhidaAux)) {
                    System.out.println("\n\t >>>>>> A conta selecionada é a mesma utilizada atualmente!");
                    System.out.println("\t\t\t\t\t\t Voltando ao menu principal!");
                    Thread.sleep(3000);
                    menuClienteLogado(clienteLogado, tipoAux);
                } else {
                    if (clienteLogado.contaDoCliente.contasMAP.get(contaEscolhidaAux.split("-")[1]) != null) {
                        System.out.println("\n\t >>>>>> Conta selecionada com sucesso!");
                        System.out.println("\t\t\t\t\t\t Voltando ao menu principal!");
                        contaAux = contaEscolhidaAux;
                        Thread.sleep(3000);
                        menuClienteLogado(clienteLogado, tipoAux);
                    } else {
                        System.out.println("\n\t >>>>>> Você não possue uma conta desse tipo!");
                        System.out.println("\t\t\t\t\t\t Voltando ao menu principal!");
                        Thread.sleep(3000);
                        menuClienteLogado(clienteLogado, tipoContaSelecionado);
                    }
                }
            }
        } else {
            System.out.println("\t\t\t\t\t\t Voltando ao menu principal!");
            Thread.sleep(3000);
            menuClienteLogado(clienteLogado, tipoContaSelecionado);
        }
    }

    public void menuAbrirNovaConta(Cliente clienteLogado, TipoConta tipoContaSelecionado) throws ParseException, InterruptedException {
        limpaMenu();
        System.out.println("\t************************************************************************************************************");
        System.out.println("\t*************************************** Bem-Vindo ao Banco DevMakers ***************************************");
        System.out.println("\t************************************************************************************************************");
        System.out.println("\t >>>>>> Siga as instruções abaixo para criar uma nova conta <<<<<<\n");
        cadastrarConta(clienteLogado, clienteLogado.escolherConta(clienteLogado.tipoCliente));
        System.out.println("\t >>>>>> Conta criada com sucesso! <<<<<<");
        Thread.sleep(3000);
        menuClienteLogado(clienteLogado, tipoContaSelecionado);
    }

}
