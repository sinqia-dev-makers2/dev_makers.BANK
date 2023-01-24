package cliente.modelos;

import conta.modelos.Conta;
import conta.modelos.TipoConta;

import java.util.Scanner;

public class Cliente implements ICliente<Conta, TipoConta>{
    Scanner sc = new Scanner(System.in);
    
    final public TipoCliente tipoCliente;
    final private TipoDocCliente tipoDocCliente;
    private String nomeDoCliente;
    final private String docCliente;
    public String numIDCliente;
    protected String senhaDoCliente;
    
    public Conta contaDoCliente;
    
    public Cliente(TipoCliente tipoCliente, String nomeDoCliente, TipoDocCliente tipoDocCliente, String docCliente, String numIDCliente) {
        this.tipoCliente = tipoCliente;
        this.nomeDoCliente = nomeDoCliente;
        this.tipoDocCliente = tipoDocCliente;
        this.docCliente = docCliente;
        this.numIDCliente = numIDCliente;
    }
    
    public double consultarSaldo(Conta contaConsultada) {
        return contaConsultada.getSaldo();
    }
    
    public void depositar(Conta contaDeposito, double valorDeposito) {
        contaDeposito.receberDeposito(valorDeposito);
    }
    
    public void sacar(Conta contaRetirada, double valorRetirada) {
        if (verificarDisponibilidade(contaRetirada,valorRetirada + (valorRetirada * contaRetirada.txSaque))) {
            contaRetirada.sacarDaConta(valorRetirada);
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
    
    public boolean verificarDisponibilidade(Conta contaConsulta, Double valorDaTransacao){
        return (valorDaTransacao <= consultarSaldo(contaConsulta));
    }
    
    public void transferir(Conta contaOrigem, Conta contaDestino, double valorTransferencia) {
        if (verificarDisponibilidade(contaOrigem,valorTransferencia + (valorTransferencia * contaOrigem.txTransferencia))) {
            contaOrigem.enviarTransferencia(contaDestino, valorTransferencia);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
    
//    private void setNomeDoCliente(String nomeDoCliente) {
//        this.nomeDoCliente = nomeDoCliente;
//    }
    
    public void abrirConta(TipoConta tipoConta, String idCliente){
        contaDoCliente.criarConta(tipoConta, idCliente);
    }
    
    @Override
    public void cadastrarSenha(String senha){
        this.senhaDoCliente = senha;
    }
    
    public TipoConta escolherConta(TipoCliente tipoCliente) {
        TipoConta tipoConta = null;
        switch (tipoCliente) {
            case FISICA -> tipoConta = getTipoContaPF();
            case JURIDICA -> tipoConta = getTipoContaPJ();
        }
        return tipoConta;
    }
    
    private TipoConta getTipoContaPF() {
        TipoConta tipoConta = null;
        System.out.println("Informe o tipo de conta PF");
        int input = sc.nextInt();
        sc.nextLine();
        switch (input) {
            case 1 -> tipoConta = TipoConta.PF_CORRENTE;
            case 2 -> tipoConta = TipoConta.PF_POUPANCA;
            case 3 -> tipoConta = TipoConta.PF_INVESTIMENTO;
            default -> getTipoContaPF();
        }
        return tipoConta;
    }
    private TipoConta getTipoContaPJ() {
        TipoConta tipoConta = null;
        System.out.println("Informe o tipo de conta PJ");
        int input = sc.nextInt();
        sc.nextLine();
        switch (input) {
            case 1 -> tipoConta = TipoConta.PJ_CORRENTE;
            case 3 -> tipoConta = TipoConta.PJ_INVESTIMENTO;
            default -> getTipoContaPJ();
        }
        return tipoConta;
    }
}