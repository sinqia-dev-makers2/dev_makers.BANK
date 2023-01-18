package pessoa;

import conta.Conta;
import enumeraveis.TipoDePessoa;
import enumeraveis.TipoID;

public class PessoaFisica extends Pessoa{
    private String cpf;
    private PessoaFisica(String nome, TipoID tipoID, TipoDePessoa tipoDePessoa) {
        setNome(nome);
        setTipoId(tipoID);
        setTipoDePessoa(tipoDePessoa);
    }
    public PessoaFisica(String nome, TipoID tipoID, TipoDePessoa tipoDePessoa, String numId) {
        super();
        this.cpf = numId;
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

    }

    @Override
    public void transferir(Conta contaOrigem, Conta contaDestino, double valor) {

    }

    @Override
    public double consultarSaldo(Conta conta) {
        return 0;
    }
}
