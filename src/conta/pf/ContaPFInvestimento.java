package conta.pf;

public class ContaPFInvestimento extends ContaPF {
    TipoContaPF tipoContaPF = TipoContaPF.INVESTIMENTO;
    
    public ContaPFInvestimento(String numConta, double saldo) {
        super(numConta + "3");
        this.saldo = saldo;
        txRendimento = 1.015;
    }
    
}
