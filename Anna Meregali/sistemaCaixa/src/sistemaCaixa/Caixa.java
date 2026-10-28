package sistemaCaixa;

import java.util.Locale;
import java.util.Scanner;

public class Caixa {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		float saldo=0;
		float deposito = 0;
		float saque=0;
		float saque_hoje = 0, limite = 500;
		int sair = 0, senha = 4321, i, chute;
		
		for(i = 1; i <= 3; i++){
			System.out.println("Digite a senha: ");
			chute = scan.nextInt();
			if(chute == senha){
				System.out.println("Senha correta");
				while(sair == 0){
					System.out.println("1-Consultar saldo;\n2-Depositar dinheiro;\n3-Sacar dinheiro;\n4-Sair");
					System.out.println("Digite sua escolha: ");
					int opcao = scan.nextInt();
					if(opcao == 1){
						consultarSaldo(saldo);
					}
					else if(opcao == 2){
						saldo = deposito(saldo, deposito);
						consultarSaldo(saldo);
					}
					else if(opcao == 3){
						float saldo_antigo = saldo;
						saldo = saque(saldo, saque, saque_hoje, limite);
						saque_hoje = saque_hoje + (saldo_antigo - saldo);
						consultarSaldo(saldo);
					}
					else if(opcao == 4){
						sair = 1;
						System.out.println("Agradecemos pela preferência, volte em breve :)");
					}
					else{
						System.out.println("Opcao invalida.");
					}
				}
				break;
			}
			else if(chute != senha){
				System.out.println("Senha incorreta");	
			}
			
			if(i == 3){
				System.out.println("Acesso bloqueado");
			}
		}	
		
	}
	public static void consultarSaldo(float a){
		System.out.printf(Locale.of("pt", "BR"), "Saldo disponivel atualmente: R$ %.2f%n", a);
	}
	public static float deposito(float a, float b){
		System.out.println("Informe o valor do deposito: R$ ");
		b = scan.nextFloat();
		if(b <= 0){
			System.out.println("Valor inválido!");
		}
		else{
			a = a + b;	
		}
		return a;
	}
	public static float saque(float a, float c,float saque_hoje, float limite){
		System.out.println("Informe o valor do saque: R$ ");
		c = scan.nextFloat();
		if(c <= 0){
			System.out.println("Valor inválido!");	
		}
		else if(c > a){
			System.out.println("Saldo insuficiente!");
		}
		else if((saque_hoje + c) > limite){
			System.out.println("Limite diário excedido!");
		}
		else{
			a = a - c;	
		}
		return a;
	}
	
}
