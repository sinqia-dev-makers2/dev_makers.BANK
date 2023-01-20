package Models;

import java.util.ArrayList;
import java.util.Random;

import Enums.TipoConta;
import Enums.TipoPessoa;
import Interfaces.IPessoa;
import Misc.LeitorDeDados;

public class Banco {
	
	LeitorDeDados leitor = new LeitorDeDados();
	
	Random rd = new Random();
	
	private ArrayList<IPessoa<?>> clientes = new ArrayList<>();
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
	
	public void menuInicial() {
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
				menuEntrarConta();
				break;
			case 2:
				limpaMenu();
				menuAbrirConta();
				break;
			case 3:
				System.exit(0);
				break;
		}
	}
	
	public void menuEntrarConta() {
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
		
		validaLogin(clientes, agencia, conta, senha);
	}
	
	public void menuAbrirConta() {
		System.out.println("\t************************************************************************************************************");
		System.out.println("\t***********************************\tBem-Vindo ao Banco DevMakers \t ***********************************");
		System.out.println("\t************************************************************************************************************");
		System.out.println("\t >>> Insira seus dados abaixo: \n");
		System.out.print("\t >>> Nome: ");
		setNome(leitor.lerTexto("a-z", "Nome: "));
		
		setAgencia(rd.nextInt(1001, 7001));
		
		System.out.print("\t >>> Agência: ");
	}
	
	public void menuUsuario(int idCliente) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public void validaCadastro() {
		for(int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).getConta().getAgencia() == agencia && clientes.get(i).getConta().getNumConta() == conta) {
				System.out.println("\n\t >>>>>>>>> Agência e/ou Conta existentes!");
				System.out.println("\n\t >>>>>>>>> Voltando para a Tela Inicial!");
				limpaMenu();
				menuInicial();
			}
		}
		System.out.println("\n\t >>>>>>>>> Cadastro Efetuado com Sucesso!");
		System.out.println("\n\t >>>>>>>>> Voltando para a Tela Inicial!");
		limpaMenu();
		menuInicial();
	}
	
	public void validaLogin(ArrayList<IPessoa<?>> clientes, int agencia, int conta, int senha) {
		for(int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).getConta().getAgencia() == agencia && clientes.get(i).getConta().getNumConta() == conta && clientes.get(i).getConta().getSenha() == senha) {
				System.out.println("\n\t >>>>>>>>> Login Efetuado com Sucesso!");
				menuUsuario(i);
			}
		}
		System.out.println("\n\t >>>>>>>>> Agência, Conta e/ou Senha incorretos!");
		System.out.println("\n\t >>>>>>>>> Voltando para a Tela Inicial!");
		menuInicial();
	}
	
	public void addCliente(ArrayList<IPessoa<?>> listaCliente, IPessoa<?> cliente) {
		listaCliente.add(cliente);
	}
	
	public IPessoa<?> getCliente(int IdCliente) {
		return clientes.get(IdCliente);
	}
	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoPessoa getTipoPess() {
		return tipoPess;
	}

	public void setTipoPess(TipoPessoa tipoPess) {
		this.tipoPess = tipoPess;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public int getAgencia() {return agencia;}

	public void setAgencia(int agencia) {this.agencia = agencia;}

	public int getConta() {return conta;}

	public void setConta(int conta) {this.conta = conta;}

	public int getSenha() {return senha;}

	public void setSenha(int senha) {this.senha = senha;}
	
}
