package conta.pf;

public class ContaPFPoupanca extends ContaPF {
    TipoContaPF tipoContaPF = TipoContaPF.POUPANCA;
    
    public ContaPFPoupanca(String numConta, double saldo) {
        super(numConta + "2");
        this.saldo = saldo;
        txRendimento = 1.010;
    }
    
}
