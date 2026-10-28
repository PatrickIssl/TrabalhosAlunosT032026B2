import java.util.Scanner;

public class Calculadora{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		System.out.printf("Informe o primeiro valor: ");
		int n1 = scan.nextInt();
		System.out.printf("Informe o segundo valor: ");
		int n2 = scan.nextInt();

		System.out.println("1-Soma\n2-Subtracao\n3-Multiplicacao\n4-Divisao");
		System.out.printf("Informe qual operacao deseja realizar: ");
		int opcao = scan.nextInt();

		if(opcao == 1){
			System.out.printf(n1 + " + " + n2 + " = " + (n1+n2));
		}
		if(opcao == 2){
			System.out.printf(n1 + " - " + n2 + " = " + (n1-n2));
		}
		if(opcao == 3){
			System.out.printf(n1 + " x " + n2 + " = " + (n1*n2));
		}
		if(opcao == 4){
			if(n2 < 0){
				System.out.println("Nao e possivel dividir por numero negativo");
			}
			else if(n2 == 0){
				System.out.println("Nao e possivel dividir por 0");
			}
			else{
				System.out.printf(n1 + " / " + n2 + " = " + (n1/n2));
			}
		}
	}
}


