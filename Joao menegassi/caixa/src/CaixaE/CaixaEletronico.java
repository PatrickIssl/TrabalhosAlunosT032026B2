package CaixaE;
import java.util.Scanner;
public class CaixaEletronico {
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int opcao = 0;	
		double val = 0;
		double saldo = 0;
		double saqd = 0;
		
		while (opcao !=4) {
		
		System.out.println("1- Sacar");
		System.out.println("2- Depositar");
		System.out.println("3- Extrato");
		System.out.println("4- sair");
		 opcao = scanner.nextInt();
		 
		 if ( opcao == 1) {
			 System.out.println("Entre com o valor que deseja sacar");
			 val = scanner.nextDouble();
			  if (val <= 0) {
				 System.out.println("Impossivel realizar o saque");
			 }
			 else if (val > saldo) {
				 System.out.println("Valor maior que saldo");
				 
			 } else if (saqd + val > 500) {
				 System.out.println("Saque diario execido");
			 }
			 
			 
			 else {
				 saldo = saldo - val;
	
				 saqd = saqd +val;
				 

			 } 
			 
			  
			 
		 }
		 else if (opcao == 2) {
			 System.out.println("Entre com o valor que deseja depositar");
			val = scanner.nextDouble();
			saldo = val;
			 
		 }
		 else if (opcao == 3) {
			 System.out.println("Sua conta tem o valor :" + saldo);
		 }
		 else if (opcao == 4) {
			 System.out.println("Saindo.... Origado por usar nosso banco" );
		 }
		 
		}
		
		
	
		

	}

}
