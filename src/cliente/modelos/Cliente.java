package cliente.modelos;

import conta.modelos.Conta;
import conta.modelos.TipoConta;
import conta.pf.ContaPF;
import conta.pj.ContaPJ;
import utilitarios.LeitorDeDados;

public class Cliente implements ICliente<Conta, TipoConta>{
		
    LeitorDeDados leitor = new LeitorDeDados();
    final public TipoCliente tipoCliente;
    protected final TipoDoc tipoDoc;
    private final String nomeDoCliente;
    protected final String docCliente;
    public String numIDCliente;
    protected String senhaDoCliente;
           
    public Conta contaDoCliente;
    
    public Cliente(TipoCliente tipoCliente, String nomeDoCliente, TipoDoc tipoDoc, String docCliente, String numIDCliente) {
        this.tipoCliente = tipoCliente;
        this.nomeDoCliente = nomeDoCliente;
        this.tipoDoc = tipoDoc;
        this.docCliente = docCliente;
        this.numIDCliente = numIDCliente;
    }
    
    public double consultarSaldo(Conta contaConsultada) {
        return contaConsultada.getSaldo();
    }
    
    public void depositar(Conta contaDeposito, double valorDeposito) {
        contaDeposito.receberDeposito(contaDeposito.getTipoConta(),valorDeposito);
    }
    
    public boolean sacar(Conta contaRetirada, int valorRetirada) {
        if (verificarDisponibilidade(contaRetirada,valorRetirada * contaRetirada.txSaque)) {
            contaRetirada.sacarDaConta(valorRetirada);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean verificarDisponibilidade(Conta contaConsulta, double valorDaTransacao){
        return (valorDaTransacao <= consultarSaldo(contaConsulta));
    }
    
    public boolean transferir(Conta contaOrigem, Conta contaDestino, double valorTransferencia) {
        if (verificarDisponibilidade(contaOrigem, valorTransferencia * contaOrigem.txTransferencia)) {
            contaOrigem.enviarTransferencia(contaDestino, valorTransferencia);
            return true;
        } else {
            return false;
        }
    }
    
    public void abrirConta(TipoConta tipoConta, String idCliente){
        if(tipoConta == TipoConta.PF_CORRENTE || tipoConta == TipoConta.PF_POUPANCA || tipoConta == TipoConta.PF_INVESTIMENTO) {
        	if(contaDoCliente == null) {
        		contaDoCliente = new ContaPF(idCliente);
        	}
        	contaDoCliente.criarConta(tipoConta, idCliente);
        }
        else {
        	if(contaDoCliente == null) {
        		contaDoCliente = new ContaPJ(idCliente);
        	}
        	contaDoCliente.criarConta(tipoConta, idCliente);
        }
    }
    
    @Override
    public void cadastrarSenha(String senha){
        this.senhaDoCliente = senha;
    }
    
    public TipoConta escolherConta(TipoCliente tipoCliente) {
        TipoConta tipoConta = null;
        switch (tipoCliente) {
            case FISICA -> tipoConta = getTipoContaPF();
            case JURIDICA -> tipoConta = getTipoContaPJ();
        }
        return tipoConta;
    }
    
    private TipoConta getTipoContaPF() {
        TipoConta tipoConta = null;
        System.out.println("\t >>> Tipo de conta ");
        System.out.println("\t\t 1 - Corrente");
		System.out.println("\t\t 2 - Poupança");
		System.out.println("\t\t 3 - Investimento");
		System.out.print("\t >>> Digite a opção desejada: ");
		switch(leitor.lerInteiro("[1-3]", "Digite a opção desejada: ")) {
            case 1 -> tipoConta = TipoConta.PF_CORRENTE;
            case 2 -> tipoConta = TipoConta.PF_POUPANCA;
            case 3 -> tipoConta = TipoConta.PF_INVESTIMENTO;
            default -> getTipoContaPF();
        }
        return tipoConta;
    }
    
    private TipoConta getTipoContaPJ() {
        TipoConta tipoConta = null;
        System.out.println("\t >>> Tipo de conta ");
        System.out.println("\t\t 1 - Corrente");
		System.out.println("\t\t 2 - Investimento");
		System.out.print("\t >>> Digite a opção desejada: ");
		switch(leitor.lerInteiro("[1-2]", "Digite a opção desejada: ")) {
            case 1 -> tipoConta = TipoConta.PJ_CORRENTE;
            case 2 -> tipoConta = TipoConta.PJ_INVESTIMENTO;
            default -> getTipoContaPJ();
        }
        return tipoConta;
    }

	@Override
	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}
 
	public String getSenha() {
		return senhaDoCliente;
	}

	public String getNomeDoCliente() {
		return nomeDoCliente;
	}
	
}