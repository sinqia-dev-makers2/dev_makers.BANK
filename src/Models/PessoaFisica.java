package Models;

public class PessoaFisica extends Pessoa{

	private int cpf;
	private char tipoPessoa;
	
	public PessoaFisica(String nome, int cpf, int idade, String endereco) {
		setNome(nome);
		setCpf(cpf);
		setIdade(idade);
		setEndereco(endereco);
		tipoPessoa = 'f';
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	public char getTipoPessoa() {
		return tipoPessoa;
	}
	
}
