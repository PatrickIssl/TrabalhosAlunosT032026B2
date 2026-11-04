import java.util.Locale;
import java.util.Scanner;
public class Banco {
	
	static Scanner scan = new Scanner(System.in);
	static double saldo = 0;
	static double diaria = 0;
	static double saque;
	
	public static void main (String [] args) {
		
	
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		int opc;
		int senha = 88;
		int tentativa = 0;
		int cont = 3;
		
		while (tentativa != senha && cont!=0) {
			
			System.out.print("Entre com a senha:");
		    tentativa = scan.nextInt();
			
			if (tentativa != senha) {
				
				cont--;
				System.out.println("Senha incorreta, faltam " + cont + " tentativas");
				
			}
			else if (tentativa == senha) {
				
	
		do {
			
			System.out.println("1 - Consultar Saldo");
			System.out.println("2 - Depositar Dinheiro");
			System.out.println("3 - Sacar Dinheiro");
			System.out.println("4 - Sair");
			opc = scan.nextInt();
			
			if (opc == 1) {
				consultarSaldo(saldo);
			}else if (opc == 2) {
				saldo = deposito(saldo);
			}else if (opc ==3) {
				System.out.print("Entre Com o Valor do Saque: R$");
				saque = scan.nextDouble();
				boolean certo = sacar(saldo,saque,diaria);
				if (certo == true) {
					saldo -= saque;
					diaria += saque;
				}
			}else if (opc == 4) {
				System.out.println("SAINDO ...");
			}
			else {
				System.out.println("Opção invalida, digite outra opção");
			}
			
		} while(opc != 4);
		
		}
			}
		
		if (cont==0) {
		System.out.println("Tente novamente mais tarde!");
		}
		
		scan.close();
		
	}
	
	public static void consultarSaldo(double saldo) {
	
		System.out.printf("Saldo Atual: R$ %.2f \n",saldo);
		
	}
	
	public static double deposito(double saldo) {
		
		System.out.print("Valor do deposito: R$");
		double valorDeposito = scan.nextDouble();
		
		if (valorDeposito <= 0) {
			
			System.out.println("Valor invalido");
			return valorDeposito;
			
		}
		else {
			
			return saldo + valorDeposito;
		}
		
		
	}
	
	public static boolean sacar(double saldo, double saque, double diaria) {
		
		if (saldo<saque) {
			System.out.println("Saque Recusado, Saldo insuficiente");
			return false;
		}
		
		else if (saque <= 0) {
			System.out.println("Saque Recusado, Valor invalido");
			return false;
		}
		else {
			
			if (diaria + saque > 500) {
				System.out.println("Limite diário atingido");
				return false;
			}else {
				return true;
			}
				
			}
		}
		
	}
	
	



