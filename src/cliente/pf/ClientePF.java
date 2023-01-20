package cliente.pf;

import cliente.Cliente;
import cliente.ICliente;
import cliente.TipoDePessoa;
import cliente.TipoIDCliente;
import conta.Conta;
import conta.IConta;
import conta.TipoDeConta;
import conta.pf.TipoContaPF;

import static cliente.TipoDePessoa.FISICA;

public class ClientePF extends Cliente implements ICliente<IConta> {
    protected ClientePF(String nomeDoCliente) {
        super(nomeDoCliente);
    }


    @Override
    public double consultarSaldo() {
        return contaDesseCliente.getSaldo();
    }

    @Override
    public void transferir(IConta contaOrigem, IConta contaDestino, double valor) {
        contaDesseCliente.enviarTransferencia(contaDestino, valor);
        contaDestino.receberTransferencia(valor);

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
}
