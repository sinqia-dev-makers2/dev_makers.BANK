package conta.pf;

import conta.Conta;
import conta.IConta;
import conta.TipoDeConta;

public class ContaPF extends Conta implements IConta<IConta, TipoContaPF> {

    private TipoContaPF tipoContaPF;
    private ContaPF(String numConta, String senha, double saldo) {
        super(numConta);
        // code
    }

    public TipoContaPF getTipoDeConta() {
        return tipoContaPF;
    }

    @Override
    public void atualizarSaldo(double valor) {
        setSaldo(valor);
    }

    @Override
    public void receberTransferencia(double valor) {
        setSaldo(getSaldo() + valor);
    }

    @Override
    public void enviarTransferencia(IConta contaDestino, double valor) {
        contaDestino.receberTransferencia(valor);
        setSaldo(getSaldo() - valor);
    }
}
