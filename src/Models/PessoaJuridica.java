package Models;

public class PessoaJuridica extends Pessoa {
	
	private String nomeFantasia;
	private int cnpj;
	private char tipoPessoa;
	
	public PessoaJuridica(String nome, String nomeFantasia, int cnpj, int idade, String endereco) {
		setNome(nome);
		setNomeFantasia(nomeFantasia);
		setCnpj(cnpj);
		setIdade(idade);
		setEndereco(endereco);
		tipoPessoa = 'j';
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	
	public char getTipoPessoa() {
		return tipoPessoa;
	}
}
