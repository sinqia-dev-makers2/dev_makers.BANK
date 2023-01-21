package conta.pj;

public class ContaPJInvestimento extends ContaPJ {
    TipoContaPJ tipoContaPJ = TipoContaPJ.INVESTIMENTO;
    
    public ContaPJInvestimento(String numConta, double saldo) {
        super(numConta + "3");
        this.saldo = saldo;
        txRendimento = 0.035;
    }
    
}
