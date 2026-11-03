package Banco;
import java.util.Scanner;

public class banco {
	   static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		float saldo = 0;
		int menu = 0;
		int i;
		float saquediario = 0;
		boolean senhacorreta = false;
		String senha = new String("123");
		for (i=0;i<=2;i++) {
			System.out.println("Entre com a senha");
			String senhatentativa = scan.nextLine();
			if(senha.equals(senhatentativa)==true) {
				senhacorreta = true;
				i=3;
			}
			else
			{
				System.out.println("Senha incorreta, tente novamente");
			}
		}
		if(senhacorreta==true)
		{
		while (menu != 4)
		{
			System.out.println("Entre 1 para verificar seu saldo;\n 2 para depositar;\n 3 para sacar \n 4 para sair");
			menu = scan.nextInt();
			
			if (menu == 1)
			{
				System.out.printf("O saldo atual é R$%.2f \n", saldo);
			}
			else if (menu == 2)
			{
				System.out.printf("Entre com o valor para depositar");
				float deposito = scan.nextInt();
				if(deposito>0)
				{
				saldo = deposito+saldo;
				} else 
				{
					System.out.println("O valor que voce esta tentando depositar nao e valido");
				}
				
			}
			else if (menu == 3) 
			{
				System.out.println("Entre com o valor que deseja sacar");
				float saque = scan.nextInt();
				if(saquediario + saque < 501)
				{
					if (saque > 0 && saque < saldo)
					{
						saquediario = saquediario + saque;
						saldo = saldo - saque;
					}
					else if (saque > saldo)
					{
						System.out.println("Saldo insuficiente");
					}
					else if (saque <= 0)
					{
						System.out.println("Saque invalido");
					}
				}
				else
				{
					System.out.println("Maior que o limite diario disponivel");
				}
				
			}
			else if (menu == 4) 
			{
				System.out.println("Obrigado por usar nosso sistema, agradecemos a preferencia");
			}
			else 
			{
				System.out.println("Opcao invalida, tente as opcoes mostradas anteriormente");
			}
		}
		
		}
		else 
		{
			System.out.println("Limite de tentativas excedidas, tente novamente mais tarde");
		}

	}

}
