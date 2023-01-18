public class ContaPoupanca implements IConta{
    private TipoDeConta tipoDeConta = TipoDeConta.POUPANCA;

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
        conta.setSaldo(conta.getSaldo() + valor*1.01);
    }

    @Override
    public void transferir(Conta origem, Conta destino, double valor) {
        if(origem.getSaldo()>= valor){
            origem.setSaldo(origem.getSaldo() - valor);
            destino.setSaldo(destino.getSaldo() + valor);
        }else {
            System.out.println("Saldo insuficiente");
        }
    }

    @Override
    public double consultarSaldo(Conta conta) {
        return conta.getSaldo();
    }
}
