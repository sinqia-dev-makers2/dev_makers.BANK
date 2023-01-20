package conta.pf;

public class ContaPFCorrente extends ContaPF {
    TipoContaPF tipoContaPF = TipoContaPF.CORRENTE;
    
    public ContaPFCorrente(String numConta, double saldo) {
        super(numConta + "1");
        this.saldo = saldo;
    }
    
}
