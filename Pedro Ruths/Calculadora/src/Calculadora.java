import java.util.Scanner;

  public class Calculadora {

  	public static void main (String[] args) {
	
		Scanner sc = new Scanner(System.in);

		double result;
		
		System.out.println("Entre com um primeiro numero: ");
		double n1 = sc.nextDouble();

		System.out.println("Entre com um segundo numero: ");
		double n2 = sc.nextDouble();

		sc.nextLine();

		System.out.println("Operacoes disponiveis:");
		System.out.println("Soma: +");
		System.out.println("Subtracao: -");
		System.out.println("Multiplicao: *");
		System.out.println("Divisao: /");
		String op = sc.nextLine();
		
		if (op.equals("+")) {
		
			result = n1 + n2;

		}
		else if(op.equals("-")) {
			
			result = n1 - n2;

		}
    		else if (op.equals("*")) {
		
			result = n1 * n2;

		}
		else if (op.equals("/")) {
	
			result = n1/n2;

		}
		else {
			result = 0;
			System.out.println("Operacao invalida, insira um valor valido");
		}
		
		System.out.println("RESULTADO = " + result);

		sc.close();
	}

  }