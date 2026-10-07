import java.util.Scanner;

public class Calculadora{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o primeiro numero");
		int numero1 = scanner.nextInt();

		System.out.println("Digite o segundo numero");
		int numero2 = scanner.nextInt();

		System.out.println("Qual operação deseja? + - * /");
		scanner.nextLine();
		String operacao = scanner.nextLine();

		if("+".equals(operacao)){
			System.out.println("A Soma é: "+ (numero1 + numero2));
		}else if("-".equals(operacao)){
			System.out.printf("A Subtração é: "+ (numero1 - numero2));
		}else if("*".equals(operacao)){
			System.out.printf("A Multiplicação é: "+ (numero1 * numero2));
		}else{
			System.out.println("A Divisão é: "+ (numero1 / numero2));
		}
	}
}