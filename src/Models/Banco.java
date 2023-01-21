package Models;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Random;

import Enums.TipoConta;
import Enums.TipoPessoa;
import Interfaces.IConta;
import Interfaces.IContaCC;
import Interfaces.IContaCC_CP;
import Interfaces.IContaCI;
import Interfaces.IPessoa;
import Misc.Formatar_CPF_CNPJ;
import Misc.LeitorDeDados;

public class Banco {
	
	LeitorDeDados leitor = new LeitorDeDados();
	Formatar_CPF_CNPJ formata = new Formatar_CPF_CNPJ();
	Random rd = new Random();
	
	private ArrayList<PessoaFisica> clientesPF = new ArrayList<>();
	private ArrayList<PessoaJuridica> clientesPJ = new ArrayList<>();
	private String nome;
	private TipoPessoa tipoPess;
	private int idade;
	private TipoConta tipoConta;
	private String cpf_cnpj;
	private int agencia;
	private int conta;
	private int senha;
	
	public void limpaMenu() {
		for(int i = 0; i < 50; i ++) {
			System.out.println();
		}
	}
	
	public void Inicio() throws ParseException {
		System.out.println("\t************************************************************************************************************");
		System.out.println("\t***********************************\tBem-Vindo ao Banco DevMakers \t ***********************************");
		System.out.println("\t************************************************************************************************************");
		System.out.println("\t >>> 1 - Entrar em sua conta");
		System.out.println("\t >>> 2 - Abrir uma conta");
		System.out.println("\t >>> 3 - Finalizar");
		System.out.print("\n\t >>> Digite a opção desejada: ");
		
		switch(leitor.lerInteiro("[1-3]", "Digite a opção desejada: ")) {
			case 1:
				limpaMenu();
				EntrarConta();
				break;
			case 2:
				limpaMenu();
				AbrirConta();
				break;
			case 3:
				System.exit(0);
				break;
		}
	}
	
	public void EntrarConta() throws ParseException {
		System.out.println("\t************************************************************************************************************");
		System.out.println("\t***********************************\tBem-Vindo ao Banco DevMakers \t ***********************************");
		System.out.println("\t************************************************************************************************************");
		System.out.println("\t >>> Entre na sua conta\n");
		System.out.print("\t >>> Agência: ");
		setAgencia(leitor.lerInteiro("\\d+", "Agência: "));
		System.out.print("\t >>> Conta: ");
		setConta(leitor.lerInteiro("\\d+", "Conta: "));
		System.out.print("\t >>> Senha: ");
		setSenha(leitor.lerInteiro("\\d+", "Senha: "));
		
		validaLogin(getClientesPF(), getClientesPJ());
	}
	
	public void AbrirConta() throws ParseException {
		System.out.println("\t************************************************************************************************************");
		System.out.println("\t***********************************\tBem-Vindo ao Banco DevMakers \t ***********************************");
		System.out.println("\t************************************************************************************************************");
		System.out.println("\t >>> Insira seus dados abaixo: \n");
		
		System.out.print("\t >>> Nome e Sobrenome: ");
		setNome(leitor.lerTexto("", "Nome e Sobrenome: "));
		
		System.out.print("\t >>> Idade: ");
		setIdade(leitor.lerInteiro("(1[8-9]|[2-9][0-9])", "Idade: "));
		
		System.out.println("\t >>> Tipo de pessoa ");
		setTipoPess();
		
		System.out.println("\t >>> Digite seu documento ");
		setCpf_cnpj(tipoPess);
		
		System.out.println("\t >>> Tipo de conta ");
		setTipoConta(tipoPess);
		
		System.out.print("\t >>> Agência: ");
		setAgencia(rd.nextInt(1001, 7001));
		System.out.println(getAgencia());
		
		System.out.print("\t >>> Conta: ");
		setConta(tipoConta);
		System.out.println(getConta());
		
		System.out.print("\t >>> Senha(Minimo 4, Máximo 8 números): ");
		setSenha(leitor.lerInteiro("[1-9][0-9]{3,7}", "Senha(Minimo 4, Máximo 8 números): "));
		
		validaCadastro(getClientesPF(), getClientesPJ());
	}
	
	public void Logado(IPessoa<TipoPessoa> cliente) {
		System.out.println("\t ************************************************************************************************************");
		System.out.println("\t ********************************************   Banco DevMakers   *******************************************");
		System.out.println("\t ************************************************************************************************************");
		System.out.println("\t >>> Bem-vindo Sr(a) " + cliente.getNome() + "\n");
		System.out.println("\t >>> Opções: ");
		System.out.println("\t\t 1 - Consultar Saldo");
		System.out.println("\t\t 2 - Saque");
		switch (cliente.getConta().getTipoConta()) {
			case CC:
				System.out.println("\t\t 3 - Depósito");
				System.out.println("\t\t 4 - Transferir");
				System.out.print("\n\t >>> Digite a opção desejada: ");
				switch(leitor.lerInteiro("[1-4]", "Digite a opção desejada: ")){
					case 1:
						verSaldo(cliente.getConta());
						break;
					case 2:
						validarSaque(cliente, cliente.getConta());
						break;
					case 3:
						validarDeposito(cliente, (IContaCC_CP) cliente.getConta());
						break;
					case 4:
						//Escolhe Agencia
						//Escolhe Conta
						validarTransferencia(cliente, (IContaCC) cliente.getConta(), (IContaCC) validaContaDestino(0,0));
						break;
				}
				break;
			case CP: 
				System.out.println("\t\t 3 - Depósito");
				System.out.print("\n\t >>> Digite a opção desejada: ");
				switch(leitor.lerInteiro("[1-3]", "Digite a opção desejada: ")){
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
				}
				break;
			case CI: 
				System.out.println("\t\t 3 - Investir");
				System.out.print("\n\t >>> Digite a opção desejada: ");
				switch(leitor.lerInteiro("[1-3]", "Digite a opção desejada: ")){
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
				}
				break;
		}
	}
	
	public void verSaldo(IConta contaCliente) {
		contaCliente.consultarSaldo();
	}
	
	public void validarSaque(IPessoa<TipoPessoa> cliente, IConta contaCliente) {
		double valor = 0;
		
		if(cliente.getTipoPessoa() == TipoPessoa.PJ) {
			valor = valor + (valor * 0.005);
		}
		
		if(validaSaldo(contaCliente, valor)) {
			contaCliente.sacar(valor);
			System.out.println("\t Saque efetuado com sucesso");
		}
		else {
			System.out.println("\t Saldo insuficiente!");
		}
	}
	
	public void validarDeposito(IPessoa<TipoPessoa> cliente, IContaCC_CP contaCliente) {
		double valor = 0;
		
		if(cliente.getTipoPessoa() == TipoPessoa.PF && cliente.getConta().getTipoConta() == TipoConta.CP) {
			valor = valor + (valor * 0.01);
		}
		
		contaCliente.depositar(valor);
		System.out.println("Depósito efetuado com sucesso!");
	}
	
	public void validarTransferencia(IPessoa<TipoPessoa> clienteOrigem, IContaCC contaClienteOrigem, IContaCC contaClienteDestino) {
		double valor = 0;
		
		if(contaClienteDestino != null) {
			if(clienteOrigem.getTipoPessoa() == TipoPessoa.PJ) {
				valor = valor + (valor * 0.005);
			}
			
			if(validaSaldo(clienteOrigem.getConta(), valor)) {
				contaClienteOrigem.transferir(-valor);
				contaClienteDestino.receberTransferencia(valor);
				System.out.println("\t Transferência efetuada com sucesso!");
			}
			else {
				System.out.println("\t Saldo insuficiente!");
			}
		}
		else {
			System.out.println("\t Conta de destino inexistente!");
		}
	}
	
	public void validarInvestimento(IPessoa<TipoPessoa> cliente, IContaCI contaCliente) {
		double valor = 0;
		
		if(cliente.getTipoPessoa() == TipoPessoa.PF) {
			valor = valor + (valor * 0.015);
		}
		else {
			valor = valor + (valor * 0.035);
		}
		
		contaCliente.investir(valor);
	}
	
	
	
	
	
	
	
	
	public IContaCC validaContaDestino(int agenciaDestino, int contaDestino) {
		for(int i = 0; i < getClientesPF().size(); i++) {
			if(getClientesPF().get(i).getConta().getAgencia() == agenciaDestino && getClientesPF().get(i).getConta().getNumConta() == contaDestino) {
				return (IContaCC) getClientesPF().get(i).getConta();
			}
		}
		
		for(int i = 0; i < getClientesPJ().size(); i++) {
			if(getClientesPJ().get(i).getConta().getAgencia() == agenciaDestino && getClientesPJ().get(i).getConta().getNumConta() == contaDestino) {
				return (IContaCC) getClientesPJ().get(i).getConta();
			}
		}
		
		return null;
	}
	
	public boolean validaSaldo(IConta contaCliente, double valor) {
		if(contaCliente.consultarSaldo() >= valor) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void validaCadastro(ArrayList<PessoaFisica> clientesPF, ArrayList<PessoaJuridica> clientesPJ) throws ParseException {
		for(int i = 0; i < clientesPF.size(); i++) {
			if(clientesPF.get(i).getConta().getAgencia() == getAgencia() && clientesPF.get(i).getConta().getNumConta() == getConta() ) {
				System.out.println("\n\t >>>>>>>>> Agência e/ou Conta existentes!");
				System.out.println("\n\t >>>>>>>>> Voltando para a Tela Inicial!");
				limpaMenu();
				Inicio();
			}
			else if(clientesPF.get(i).getCpfCpnj().equals(getCpf_cnpj())) {
				System.out.println("\n\t >>>>>>>>> Esse CPF/CNPJ já possui uma conta aberta!");
				System.out.println("\n\t >>>>>>>>> Voltando para a Tela Inicial!");
				limpaMenu();
				Inicio();
			}
		}
		
		for(int i = 0; i < clientesPJ.size(); i++) {
			if(clientesPJ.get(i).getConta().getAgencia() == getAgencia() && clientesPJ.get(i).getConta().getNumConta() == getConta()) {
				System.out.println("\n\t >>>>>>>>> Agência e/ou Conta existentes!");
				System.out.println("\n\t >>>>>>>>> Voltando para a Tela Inicial!");
				limpaMenu();
				Inicio();
			}
			else if(clientesPJ.get(i).getCpfCpnj().equals(getCpf_cnpj())) {
				System.out.println("\n\t >>>>>>>>> Esse CPJ/CNPJ já possui uma conta aberta!");
				System.out.println("\n\t >>>>>>>>> Voltando para a Tela Inicial!");
				limpaMenu();
				Inicio();
			}
		}
		
		switch(getTipoPess()) {
			case PF:
				switch(getTipoConta()){
					case CC:
						addCliente(new PessoaFisica(getNome(), getIdade(), getCpf_cnpj(), new ContaCorrente(getAgencia(), getConta(), getSenha())));
						break;
					case CP:
						addCliente(new PessoaFisica(getNome(), getIdade(), getCpf_cnpj(), new ContaPoupanca(getAgencia(), getConta(), getSenha())));
						break;
					case CI:
						addCliente(new PessoaFisica(getNome(), getIdade(), getCpf_cnpj(), new ContaInvestimento(getAgencia(), getConta(), getSenha())));
						break;
				}
				break;
			case PJ:
				switch(getTipoConta()){
					case CC:
						addCliente(new PessoaJuridica(getNome(), getIdade(), getCpf_cnpj(), new ContaCorrente(getAgencia(), getConta(), getSenha())));
						break;
					case CI:
						addCliente(new PessoaJuridica(getNome(), getIdade(), getCpf_cnpj(), new ContaInvestimento(getAgencia(), getConta(), getSenha())));
						break;
					default:
						break;
				}
				break;
		}
		
		System.out.println("\n\t >>>>>>>>> Cadastro Efetuado com Sucesso!");
		System.out.println("\n\t >>>>>>>>> Voltando para a Tela Inicial!");
		limpaMenu();
		Inicio();
	}
	
	public void validaLogin(ArrayList<PessoaFisica> clientesPF, ArrayList<PessoaJuridica> clientesPJ) throws ParseException {
		for(int i = 0; i < clientesPF.size(); i++) {
			if(clientesPF.get(i).getConta().getAgencia() == agencia && clientesPF.get(i).getConta().getNumConta() == conta && clientesPF.get(i).getConta().getSenha() == senha) {
				System.out.println("\n\t >>>>>>>>> Login Efetuado com Sucesso!");
				//Logado(clientesPF.get(i));
			}
		}
		for(int i = 0; i < clientesPJ.size(); i++) {
			if(clientesPJ.get(i).getConta().getAgencia() == agencia && clientesPJ.get(i).getConta().getNumConta() == conta && clientesPJ.get(i).getConta().getSenha() == senha) {
				System.out.println("\n\t >>>>>>>>> Login Efetuado com Sucesso!");
				//Logado(clientesPJ.get(i));
			}
		}
		System.out.println("\n\t >>>>>>>>> Agência, Conta e/ou Senha incorretos!");
		System.out.println("\n\t >>>>>>>>> Voltando para a Tela Inicial!");
		Inicio();
	}
	
	public void addCliente(PessoaFisica cliente) {clientesPF.add(cliente);}
	
	public void addCliente(PessoaJuridica cliente) {clientesPJ.add(cliente);}
	
	public ArrayList<PessoaFisica> getClientesPF() {return this.clientesPF;}
	
	public ArrayList<PessoaJuridica> getClientesPJ(){return this.clientesPJ;}
		
	public String getNome() {return nome;}

	public void setNome(String nome) {this.nome = nome;}

	public TipoPessoa getTipoPess() {return tipoPess;}

	public void setTipoPess() {
		System.out.println("\t\t 1 - Fisica");
		System.out.println("\t\t 2 - Juridica");
		System.out.print("\t >>> Digite a opção desejada: ");
		switch(leitor.lerInteiro("[1-2]", "Digite a opção desejada: ")) {
			case 1:
				this.tipoPess = TipoPessoa.PF;
				break;
			case 2:
				this.tipoPess = TipoPessoa.PJ;
				break;
		}
	}

	public int getIdade() {return idade;}

	public void setIdade(int idade) {this.idade = idade;}

	public TipoConta getTipoConta() {return tipoConta;}
	
	public void setTipoConta(TipoPessoa tipoPess) {
		if(tipoPess == TipoPessoa.PF) {
			System.out.println("\t\t 1 - Corrente");
			System.out.println("\t\t 2 - Poupança");
			System.out.println("\t\t 3 - Investimento");
			System.out.print("\t >>> Digite a opção desejada: ");
			switch(leitor.lerInteiro("[1-3]", "Digite a opção desejada: ")) {
				case 1:
					this.tipoConta = TipoConta.CC;
					break;
				case 2:
					this.tipoConta = TipoConta.CP;
					break;
				case 3:
					this.tipoConta = TipoConta.CI;
					break;
			}
		}
		else {
			System.out.println("\t\t 1 - Corrente");
			System.out.println("\t\t 2 - Investimento");
			System.out.print("\t >>> Digite a opção desejada: ");
			switch(leitor.lerInteiro("[1-2]", "Digite a opção desejada: ")) {
				case 1:
					this.tipoConta = TipoConta.CC;
					break;
				case 2:
					this.tipoConta = TipoConta.CI;
					break;
			}
		}
	}

	public String getCpf_cnpj() {return cpf_cnpj;}

	public void setCpf_cnpj(TipoPessoa tipoPess) throws ParseException {
		if(tipoPess == TipoPessoa.PF) {
			System.out.print("\t >>>>>> CPF: ");
			this.cpf_cnpj = formata.formatarString(leitor.lerTexto("[0-9]{11}", "CPF: "), tipoPess);
		}
		else {
			System.out.print("\t >>>>>> CNPJ: ");
			this.cpf_cnpj = formata.formatarString(leitor.lerTexto("[0-9]{14}", "CNPJ: "), tipoPess);
		}
	}

	public int getAgencia() {return agencia;}

	public void setAgencia(int agencia) {this.agencia = agencia;}

	public int getConta() {return conta;}

	public void setConta(int conta) {this.conta = conta;}
	
	public void setConta(TipoConta tipoConta) {
		if(tipoConta == TipoConta.CC) {
			this.conta = rd.nextInt(10001, 99999);
		}
		else if (tipoConta == TipoConta.CP) {
			this.conta = rd.nextInt(100001, 999999);
		}
		else {
			this.conta = rd.nextInt(1000001, 9999999);
		}
	}

	public int getSenha() {return senha;}

	public void setSenha(int senha) {this.senha = senha;}
	
}