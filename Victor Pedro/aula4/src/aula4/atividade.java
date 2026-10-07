package aula4;

import java.util.Random;
import java.util.Scanner;

public class atividade {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		//exercicioum();
       // exerciciodois();
       // exerciciotres();
        exercicioquatro();
        
        scan.close();
	}
	//jogo de adivinhação
	public static void exercicioum() {
		Random random = new Random();		
		int numeroAleatorio = random.nextInt(11);
		boolean acertou = false;	
		while(!acertou) {
			System.out.println("chute um valor: ");
			int numero = scan.nextInt();
			scan.nextLine();
			if (numero < numeroAleatorio) {
				System.out.println("Chute mais alto");
			}else if (numero > numeroAleatorio) {
				System.out.println("Chute mais baixo");
				
				
			}else {
				System.out.println("Acertou");
		        acertou=true;}
		
	
	  }
	}

	public static void exerciciodois() {
		System.out.println("Escreva os numeros para realizar a soma dos digitos");
		int numero = scan.nextInt();
		scan.nextLine();
		int soma = 0; 
				while(numero != 0) {
					int digito = numero % 10;
							soma += digito;
							numero = numero / 10;
				}
		System.out.println("A soma dos digitos é: " +soma);
	}

	public static void exerciciotres() {
		System.out.println("Informe o primeiro valor");
		int numeroUm = scan.nextInt();
		System.out.println("Informe o segundo valor");
		int numeroDois = scan.nextInt();
		int soma = 0;
		for (int i = numeroUm; i <=numeroDois; i++) {
			if(i % 2 == 1) {
				soma += i;
			}
		}
	      
		 System.out.println("A soma dos valores impares é: "+soma);

	}
	
//  Múltiplos de um Número Escreva um programa que receba dois números
//  inteiros positivos: um número base e um limite. O programa deve imprimir
//  todos os múltiplos do número base até o limite especificado. Por exemplo,
//  se base = 3 e limite = 10, a saída deve ser: 3, 6, 9.
 public static void exercicioquatro() {
     System.out.println("Informe a base: ");
     int base = scan.nextInt();
     System.out.println("Informe o limite: ");
     int limite = scan.nextInt();
     for (int i = base; i <= limite; i++) {
         if(i % base == 0) {
             System.out.printf("O numero %d é divisivel por %d \n",i, base);
	
	}
     }
 }
	
	
}



