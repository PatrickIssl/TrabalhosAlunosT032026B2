package aulatres;

import java.util.Random;
import java.util.Scanner;

public class Principal2 {

	public static void main (String [] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int randomNumber = random.nextInt(11);
        boolean acertou = false;
        while (!acertou) {
        System.out.println("Digite um numero de 0 a 10 para voce tentar acertar o que saira aleatoriamente!");
        double numUm = sc.nextDouble();
        if (numUm > randomNumber && numUm != randomNumber) {
        	System.out.println("O numero e menor!");
        } else if (numUm < randomNumber && numUm != randomNumber){
        	System.out.println("O numero e maior!");
        }
        
        if (numUm == randomNumber) {
        	System.out.println("Voce acertou!");
        	acertou = true;
        	}
        }
	}
}