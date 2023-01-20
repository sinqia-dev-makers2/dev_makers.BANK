package Misc;

import java.util.Scanner;

public class LeitorDeDados {
	
	Scanner sc = new Scanner(System.in);
	int inteiro;
	double decimal;
	char caracter;
	String texto;
	
	public int lerInteiro(String regex) {
		texto = sc.next();
		while (!texto.matches(regex)) {
			System.out.println("\n\t >>>>>>>> Erro! Digite o número novamente!\n");
			System.out.print("\t >>> ");
			texto = sc.next();
		}
		inteiro = Integer.parseInt(texto);
		return inteiro;
	}
	
	public double lerDecimal(String regex) {
		texto = sc.next();
		while (!texto.matches(regex)) {
			System.out.println("\n\t >>>>>>>>> Erro! Digite o valor novamente!\n");
			System.out.print("\t >>> ");
			texto = sc.next();
		}
		decimal = Double.parseDouble(texto);
		return decimal;
	}
	
	public char lerCaracter(String regex) {
		texto = sc.next();
		while(texto.length() > 1 || texto.length() == 0 || !texto.toLowerCase().matches(regex)) {
			System.out.println("\n\t >>>>>>>>> Erro! Digite o caracter novamente!\n");
			System.out.print("\t >>> ");
			texto = sc.next();
		}
		caracter = texto.charAt(0);
		return caracter;
	}
	
	public String lerTexto(String regex) {
		texto = sc.nextLine();
		while(texto.length() > 1 || texto.length() == 0) {
			System.out.println("\n\t >>>>>>>>> Erro! Digite novamente!\n");
			System.out.print("\t >>> ");
			texto = sc.nextLine();
		}
		return texto;
	}
}
