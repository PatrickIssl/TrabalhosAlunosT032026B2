package aulatres;

import java.util.Scanner;

public class Principal {

	public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        
		System.out.println("Digite o primeiro numero: ");
		double numUm = sc.nextDouble();
		
		System.out.println("Digite o segundo numero: ");
		double numDois = sc.nextDouble();
		
		sc.nextLine(); 
		
		System.out.println("Digite o simbulo da operação desejada: ");
		String operacao = sc.nextLine();

		if(operacao.equals("+")) {
		    System.out.printf("A soma de %f + %f = %f", numUm, numDois, numUm+numDois);
		}else if(operacao.equals("-")) {
		    System.out.printf("A subtracao de %f - %f = %f", numUm, numDois, numUm-numDois);
		}else if(operacao.equals("*")) {
		    System.out.printf("A multiplicacao de %f * %f = %f", numUm, numDois, numUm*numDois);
		}else if(operacao.equals("/")) {
		    System.out.printf("A divisao de %f / %f = %f", numUm, numDois, numUm/numDois);
		}
		
		
	}
}