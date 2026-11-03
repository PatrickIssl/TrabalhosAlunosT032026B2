import java.util.Scanner;

public class ExercicioNome{
	public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	
	System.out.printf("Qual seu Nome?");
	String nome = scan.nextLine( );

	System.out.printf("Qual sua Idade?");
	int idade = scan.nextInt( );

		if (idade >= 18){
		System.out.printf(nome+" voce e maior de Idade!");
		}
	}
} 