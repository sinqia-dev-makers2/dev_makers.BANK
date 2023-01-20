package cliente;

import conta.Conta;
import conta.IConta;
import conta.TipoDeConta;

public abstract class Cliente {
    private String nomeDoCliente;
    protected String numIdCliente;
    private TipoDePessoa tipoDePessoa;
    public IConta contaDesseCliente; // public Conta[] contasDesseCliente; cada cliente pode ter mais de uma conta, uma de cada tipo
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
}