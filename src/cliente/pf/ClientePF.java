package cliente.pf;

import cliente.Cliente;
import cliente.TipoDePessoa;
import cliente.TipoIDCliente;
import conta.Conta;

import static cliente.TipoDePessoa.FISICA;

public class ClientePF extends Cliente {
    final TipoDePessoa tipoDePessoa = FISICA;
    final TipoIDCliente tipoIDCliente = TipoIDCliente.CPF;
    private String cpf;
    
    public ClientePF(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
        this.numIdCliente = cpf;    //gerar um número do cliente aleatótio, gerado pelo banco
    }
    private void setSenha(String senha) {
        this.senhaDoCliente = senha;
    }
    
    @Override
    public void depositar(double valorDeposito) {
        contaDesseCliente.atualizarSaldo(consultarSaldo() + valorDeposito);
    }
    
    public boolean verificarDisponibilidade(Double valorDaTransacao){
        return (valorDaTransacao <= consultarSaldo());
    }
    
    @Override
    public void sacar(double valorRetirada) {
        if (verificarDisponibilidade(valorRetirada)) {
            contaDesseCliente.atualizarSaldo(consultarSaldo() - valorRetirada);
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
    
    @Override
    public void transferir(Conta contaDestino, double valorTransferencia) {
        contaDesseCliente.enviarTransferencia(valorTransferencia);
        contaDestino.receberTransferencia(valorTransferencia);
    }
}
