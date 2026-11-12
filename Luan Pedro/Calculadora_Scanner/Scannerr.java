package Calculadora_Scanner;

import java.util.Scanner;

public class Scannerr {
	public static void main (String[] args) {
		Scanner nomepr = new Scanner (System.in);
		Scanner idadepr = new Scanner (System.in);
			System.out.print("Qual seu nome?");
			String nome = nomepr.nextLine();
			System.out.print("Qual seu idade?");
			int idade = nomepr.nextInt();
			if (idade >= 18) {
			System.out.println("Seu nome: " + nome + ", idade: " + idade + ". Idade permitida (18 anos ou mais)");
			} else {
			System.out.println("Seu nome: " + nome + ", idade: " + idade + ". Idade reprovada (18 anos ou menos)");
			}
		nomepr.close();	
		
	}
}