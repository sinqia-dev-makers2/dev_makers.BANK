package conta.pj;

public class ContaPJInvestimento extends ContaPJ {
    TipoContaPJ tipoContaPJ = TipoContaPJ.INVESTIMENTO;
    protected double txRendimento = 0.035;
    
    public ContaPJInvestimento(String numConta, double saldo) {
        super(numConta + "3");
        this.saldo = saldo;
    }
    
}
