package exercicioArray;
import java.util.ArrayList;
import java.util.Scanner;


public class ArrayLists {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
			

	ArrayList<String> nomes = new ArrayList();
	 System.out.println("Informe 5 nomes:");
	 
	 for (int i = 0; i < 5; i++) {
         System.out.print("Digite o nome: " + (i + 1) + ": ");
         String nomes1 = scan.next();
         nomes.add(nomes1);
		}
	     
}

	
}