package cliente;

import conta.Conta;
import enumeraveis.TipoDeConta;
import enumeraveis.TipoDePessoa;
import interfaces.IPessoa;

public abstract class Cliente implements IPessoa {
    private String nome;
    protected String numId;
    private TipoDePessoa tipoDePessoa;
    public Conta[] numConta;
    String senha;
    
    Cliente(String nome) {
        this.nome = nome;
    }
    
    void setNome(String nome) {
        this.nome = nome;
    }
    String getNome() {
        return nome;
    }
    
    void setTipoDePessoa(enumeraveis.TipoDePessoa tipoDePessoa) {
        this.tipoDePessoa = tipoDePessoa;
    }
    TipoDePessoa getTipoDePessoa() {
        return tipoDePessoa;
    }
    
    String getSenha() {
        return senha;
    }
    
    public void abrirConta(TipoDeConta tipoDeConta) {
        // implementar abertura de conta
    }
}