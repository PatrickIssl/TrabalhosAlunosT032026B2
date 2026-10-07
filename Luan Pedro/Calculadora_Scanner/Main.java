package Calculadora_Scanner;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner nomepr = new Scanner(System.in);
		Scanner idadepr = new Scanner(System.in);

		System.out.print("Qual seu nome? ");
		String nome = nomepr.nextLine();

		System.out.print("Qual sua idade? ");
		int idade = idadepr.nextInt();

		if (idade >= 18)
		{
			System.out.println("Seu nome: " + nome + ". Idade: " + idade + ". Maior de idade, idade aprovada!");
		} else{
			System.out.println("Seu nome: " + nome + ". Idade: " + idade + ". Menor de idade, idade reprovada!");
		}
	}
}