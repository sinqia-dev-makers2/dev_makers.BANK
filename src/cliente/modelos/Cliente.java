package cliente.modelos;

import conta.modelos.Conta;
import conta.modelos.TipoConta;

import java.util.Scanner;

public class Cliente implements ICliente<Conta, TipoConta>{
    Scanner sc = new Scanner(System.in);
    
    public TipoDeCliente tipoDeCliente;
    private TipoDocCliente tipoDocCliente;
    
    private String nomeDoCliente;
    private String docCliente;
    
    public String numIDCliente;
    protected String senhaDoCliente;
    
    public Conta contaDoCliente;
    
    public Cliente(TipoDeCliente tipoDeCliente, String nomeDoCliente, TipoDocCliente tipoDocCliente, String docCliente, String numIDCliente) {
        this.tipoDeCliente = tipoDeCliente;
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
    
    public String getNomeDoCliente() {
        return nomeDoCliente;
    }
    
    public TipoDeCliente getTipoDePessoa() {
        return tipoDeCliente;
    }
    
    protected String getSenhaDoCliente() {
        return senhaDoCliente;
    }
    
    
    public void abrirConta(TipoConta tipoConta, String idCliente){
        contaDoCliente.criarConta(tipoConta, idCliente);
    }
    
    @Override
    public void cadastrarSenha(String senha){
        this.senhaDoCliente = senha;
    }
    
    public TipoConta escolherConta(TipoDeCliente tipoDeCliente) {
        TipoConta tipoConta = null;
        switch (tipoDeCliente) {
            case FISICA -> tipoConta = getTipoContaPF();
            case JURIDICA -> tipoConta = getTipoContaPJ();
        }
        return tipoConta;
    }
    
    private TipoConta getTipoContaPF() {
        TipoConta tipoConta = null;
        String input = sc.nextLine();
        switch (input) {
            case "corrente" -> tipoConta = TipoConta.PF_CORRENTE;
            case "poupança" -> tipoConta = TipoConta.PF_POUPANCA;
            case "investimento" -> tipoConta = TipoConta.PF_INVESTIMENTO;
            default -> getTipoContaPF();
        }
        return tipoConta;
    }
    private TipoConta getTipoContaPJ() {
        TipoConta tipoConta = null;
        String input = sc.nextLine();
        switch (input) {
            case "corrente" -> tipoConta = TipoConta.PJ_CORRENTE;
            case "investimento" -> tipoConta = TipoConta.PJ_INVESTIMENTO;
            default -> getTipoContaPJ();
        }
        return tipoConta;
    }
}