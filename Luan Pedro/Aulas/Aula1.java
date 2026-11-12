package Aulas;

import java.util.Scanner;

public class Aula1 {
    public static void main(String[] args) {
        System.out.println("Digite sua nome: ");
        Scanner novo = new Scanner(System.in);
        String nome = novo.nextLine();
        System.out.println("Digite sua idade: ");
        int idade = novo.nextInt();

        System.out.printf("Eai, seu nome é %s e você tem %d anos. Você é ", nome, idade);
        if (idade >=18) {
            System.out.print("Maior de idade");
        } else {
            System.out.print("Menor de idade");
        }
    }
}
