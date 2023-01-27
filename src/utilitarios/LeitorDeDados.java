package utilitarios;

import java.util.Scanner;

public class LeitorDeDados {
	
	Scanner sc = new Scanner(System.in);
	int inteiro;
	double decimal;
	char caracter;
	String texto;
	
	public int lerInteiro(String regex, String msg) {
		texto = sc.nextLine();
		while (!texto.matches(regex) || texto.contains(" ")) {
			System.out.println("\t\t\t\t\t\t Erro! Digite o número novamente!");
			System.out.print("\t >>> " + msg);
			texto = sc.nextLine();
		}
		inteiro = Integer.parseInt(texto);
		return inteiro;
	}
	
	public double lerDecimal(String regex, String msg) {
		texto = sc.nextLine();
		while (!texto.matches(regex) || texto.contains(" ")) {
			System.out.println("\t\t\t\t\t\t Erro! Digite o valor novamente!");
			System.out.print("\t >>> " + msg);
			texto = sc.nextLine();
		}
		decimal = Double.parseDouble(texto);
		return decimal;
	}
	
	public char lerCaracter(String regex, String msg) {
		texto = sc.nextLine();
		while(texto.trim().length() > 1 || texto.trim().length() == 0 || !texto.toLowerCase().matches(regex) || texto.contains(" ")) {
			System.out.println("\t\t\t\t\t\t Erro! Digite o caracter novamente!");
			System.out.print("\t >>> " + msg);
			texto = sc.nextLine();
		}
		caracter = texto.toLowerCase().charAt(0);
		return caracter;
	}
	
	public String lerTexto(String regex, String msg) {
		texto = sc.nextLine();
		if(regex.equals("")) {
			while(texto.trim().length() < 3) {
				System.out.println("\t\t\t\t\t\t Erro! Digite novamente!");
				System.out.print("\t >>> " + msg);
				texto = sc.nextLine();
			}
		}
		else {
			while(!texto.matches(regex)) {
				System.out.println("\t\t\t\t\t\t Erro! Digite novamente!");
				System.out.print("\t >>> " + msg);
				texto = sc.nextLine();
			}
		}
		
		return texto;
	}
}
