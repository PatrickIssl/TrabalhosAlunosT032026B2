import java.util.Scanner;
public class mainMaquinarefri {

		public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);

	        // Maquina Inicia com 5 refri no estoque inicial
	        Maquinarefri maquina = new Maquinarefri(5);

	        System.out.println("COMPRE AQUI SEU REFRIGERANTE");
	        maquina.exibirEstado();

	        // lê a quantidade de compra
	        System.out.print("Digite a quantidade de refrigerantes que deseja comprar: ");
	        int qtd = scan.nextInt();

	        // Leitura do valor pago pelo cliente
	        System.out.print("Digite o valor em dinheiro entregue (ex: 10,00): ");
	        double valorPago = scan.nextDouble();

	        // Realiza a compra
	        maquina.compra(qtd, valorPago);

	        // Exibe estoque atual
	        maquina.exibirEstado();

	        scan.close();
	    }
	}