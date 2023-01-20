package cliente.pj;

import cliente.Cliente;
import cliente.ICliente;
import conta.IConta;

public class ClientePJ extends Cliente implements ICliente<IConta> {
    protected ClientePJ(String nomeDoCliente) {
        super(nomeDoCliente);
    }

    @Override
    public double consultarSaldo() {
        return contaDesseCliente.getSaldo();
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
        if (verificarDisponibilidade(valorRetirada + (valorRetirada * 0.005))) {
            contaDesseCliente.atualizarSaldo(consultarSaldo() - (valorRetirada + (valorRetirada * 0.005)));
        } else {
            System.out.println("Saldo insuficiente");
        }

    }

    @Override
    public void transferir(IConta contaOrigem, IConta contaDestino, double valorTransferencia) {
        if (verificarDisponibilidade(valorTransferencia + (valorTransferencia * 0.005))) {
            contaDesseCliente.enviarTransferencia(contaDestino, valorTransferencia + (valorTransferencia * 0.005));
            contaDestino.receberTransferencia(valorTransferencia);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
}
