package conta.pf;

public class ContaPFPoupanca extends ContaPF {
    TipoContaPF tipoContaPF = TipoContaPF.POUPANCA;
    protected double txRendimento = 0.010;
    
    public ContaPFPoupanca(String numConta, double saldo) {
        super(numConta + "2");
        this.saldo = saldo;
    }
    
}
