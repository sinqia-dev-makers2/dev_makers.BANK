package conta.pj;

public class ContaPJCorrente extends ContaPJ {
    TipoContaPJ tipoContaPJ = TipoContaPJ.CORRENTE;
    
    public ContaPJCorrente(String numConta, double saldo) {
        super(numConta + "1");
        this.saldo = saldo;
    }
    
}