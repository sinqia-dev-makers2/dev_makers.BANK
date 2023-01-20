package Main;

import java.text.ParseException;

import Models.Banco;
import Models.ContaCorrente;
import Models.PessoaFisica;

public class Aplicacao {

	public static void main(String[] args) throws ParseException {
		
		Banco banco = new Banco();
		
		
		
		banco.Logado(new PessoaFisica("Matheus Leite", 26, "469.197.528-40", new ContaCorrente(1610, 66886, 66989794)));
		
		
		
		
	}

}
