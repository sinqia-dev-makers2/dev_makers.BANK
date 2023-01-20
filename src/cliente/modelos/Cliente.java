package cliente.modelos;

import conta.modelos.Conta;
import conta.modelos.TipoConta;

public abstract class Cliente implements ICliente<Conta, TipoConta>{
    private TipoDeCliente tipoDeCliente;
    private TipoIDCliente tipoIDCliente;
    
    private String nomeDoCliente;
    protected String numIDCliente;
    protected String senhaDoCliente;
    
    public Conta contaDoCliente;
    // public Conta[] contasDesseCliente; cada cliente pode ter mais de uma conta, uma de cada tipo
    
    protected Cliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
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
    
    String getNomeDoCliente() {
        return nomeDoCliente;
    }
    
    TipoDeCliente getTipoDePessoa() {
        return tipoDeCliente;
    }
    
    protected String getSenhaDoCliente() {
        return senhaDoCliente;
    }
    
    
    public abstract void abrirConta(TipoConta tipoConta);


}