package avaliacao;

import java.util.Scanner;

public class MainPedido {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Digite o nome do cliente: ");
	    String nome = scan.nextLine();  
	    Pedido pedido = new Pedido(nome);  
	    int opcao;

	    do {
	        System.out.println("\n----MENU----");
	        System.out.println("1 - Adicionar lanches");
	        System.out.println("2 - Calcular total");
	        System.out.println("3 - Finalizar pedido");
	        System.out.println("4 - Exibir pedido");
	        System.out.println("0 - Sair");
	        System.out.print("Escolha uma opção: ");
	        opcao = scan.nextInt();

	        if (opcao == 1) {
	        	if (pedido.getStatus().equals("Finalizado")) {
	        	    System.out.println("Operação não permitida! O pedido já foi finalizado.");
	        	}
	        	else {
	        	    System.out.print("Quantos lanches deseja adicionar? ");
	        	    int qtd = scan.nextInt();
	        	    pedido.adicionarLanches(qtd);
	        	}
	        }
	        else if (opcao == 2) {
	            System.out.println("Total do pedido: R$ " + pedido.calcularTotal());
	        } 
	         else if (opcao == 3) {
	            pedido.finalizarPedido();
	        } 
	        else if (opcao == 4) {
	            pedido.exibirPedido();
	        } 
	        else if (opcao == 0) {
	            System.out.println("Encerrando o atendimento. Até logo!");
	        } 
	        else {
	            System.out.println("Opção inválida! Escolha uma opão válida!");
	        }
	      
	    }
	    while (opcao != 0);
	    scan.close();
	}

}
