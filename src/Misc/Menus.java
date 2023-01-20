package Misc;

public class Menus {
	
	LeitorDeDados leitor = new LeitorDeDados();
	
	public void menuInicial() {
		System.out.println("\t************************************************************************************************************");
		System.out.println("\t***********************************\tBem-Vindo ao Banco DevMakers \t ***********************************");
		System.out.println("\t************************************************************************************************************");
		System.out.println("\t >>> 1 - Entrar em sua conta");
		System.out.println("\t >>> 2 - Abrir uma conta");
		System.out.println("\t >>> 3 - Finalizar");
		System.out.print("\n\t >>> Digite a opção desejada: ");
		
		switch(leitor.lerInteiro("[1-3]")) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				System.exit(0);
				break;
		}
	}
	
	
}
