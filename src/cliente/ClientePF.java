package cliente;

import conta.Conta;
import enumeraveis.TipoDePessoa;
import enumeraveis.TipoID;

import static enumeraveis.TipoDePessoa.FISICA;

public class ClientePF extends Cliente {
    final TipoDePessoa tipoDePessoa = FISICA;
    final TipoID tipoID = TipoID.CPF;
    private String cpf;
    
    private ClientePF(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
        this.numId = cpf;
        // pensei em gerar um número do cliente diferente, gerado pelo banco,
        // com algum componente aleatório, para não deixar CPF ou CNPJ público
    }
    void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Override
    public void sacar(Conta conta, double valor) {
        if(conta.getSaldo()>= valor){
            conta.setSaldo(conta.getSaldo() - valor);
        }
        else {
            System.out.println("Saldo insuficiente");
        }
    }

    @Override
    public void depositar(Conta conta, double valor) {
        //
    }

    @Override
    public void transferir(Conta contaOrigem, Conta contaDestino, double valor) {
        //
    }

    @Override
    public double consultarSaldo(Conta conta) {
        return 0;
    }
}
