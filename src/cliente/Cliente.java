package cliente;

import conta.Conta;
import conta.TipoDeConta;

public abstract class Cliente implements ICliente {
    private String nomeDoCliente;
    protected String numIdCliente;
    private TipoDePessoa tipoDePessoa;
    public Conta contaDesseCliente; // public Conta[] contasDesseCliente; cada cliente pode ter mais de uma conta, uma de cada tipo
    protected String senhaDoCliente;
    
    protected Cliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }
    
    String getNomeDoCliente() {
        return nomeDoCliente;
    }
    
    TipoDePessoa getTipoDePessoa() {
        return tipoDePessoa;
    }
    
    protected String getSenhaDoCliente() {
        return senhaDoCliente;
    }
    
    public void abrirConta(TipoDeConta tipoDeConta) {
        // implementar abertura de conta
    }
    
    @Override
    public double consultarSaldo() {
        return contaDesseCliente.consultarSaldo();
    }
}