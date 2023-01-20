package conta.pf;

public class ContaPFInvestimento extends ContaPF {
    TipoContaPF tipoContaPF = TipoContaPF.INVESTIMENTO;
    protected double txRendimento = 0.015;
    
    public ContaPFInvestimento(String numConta, double saldo) {
        super(numConta + "3");
        this.saldo = saldo;
    }
    
}
