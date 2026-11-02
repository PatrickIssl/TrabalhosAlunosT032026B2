package fag;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import fag.objetos.Produto;

public class Principal {

	
	static Scanner scan = new Scanner(System.in);
	static List<Produto> produtos = new ArrayList<Produto>();
	
	public static void main(String[] args) {
		mostrarMenu();
	}
	
	public static void mostrarMenu() {
		int escolhaUsuario = 0;
		do {
			System.out.println("\n---------------Sistema Estoque---------------");
			System.out.println("Selecione uma opção a seguir: ");
			System.out.println("1 - Cadastrar Produto");
			System.out.println("2 - Visualizar Estoque");
			System.out.println("3 - Apagar produto");
			System.out.println("4 - Alterar produto");
			System.out.println("0 - Sair");
			escolhaUsuario = scan.nextInt();
			scan.nextLine();
			validarEscolha(escolhaUsuario);
		} while (escolhaUsuario != 0);
	}

	public static void validarEscolha(int escolhaUsuario) {
		switch (escolhaUsuario) {
		case 1: {
			cadastrarProduto();
			break;
		}
		case 2: {
			visualizarProdutos();
			break;
		}
		case 3:{
			apagarProduto();
			break;
		}
		case 4:{
			alterarProduto();
			break;
		}
		case 0: {
			System.out.println("Obrigado por utilizar o sistema!");
			break;
		}
		default:
			System.out.println("Digite uma opção válida!");
		}
	}

	public static void alterarProduto() {
		visualizarProdutos();
		System.out.println("Selecione a opção que deseja alterar: ");
		int escolha = scan.nextInt() - 1;
		scan.nextLine();
		if(escolha > produtos.size() || escolha < 0) {
			System.out.println("Selecione um valor válido!");
			return;
		}
		Produto produto = produtos.get(escolha);
		mostrarMenuAlterarProduto(produto);
		
	}

	public static void mostrarMenuAlterarProduto(Produto produto) {
		int escolha = 0;
		do {
			System.out.println("Selecione a opção que deseja alterar: ");
			System.out.println("1 - Nome");
			System.out.println("2 - Preço");
			System.out.println("3 - Quantidade");
			System.out.println("0 - Sair");
			escolha = scan.nextInt();
			scan.nextLine();
			alterarValor(produto, escolha);
		} while (escolha != 0);
	}
	
	

	public static void alterarValor(Produto produto, int escolha) {
		if(escolha == 1) {
			System.out.println("Digite o novo nome: ");
			produto.setNome(scan.nextLine());
			System.out.println("Nome alterado com sucesso!");
		}else if (escolha == 2) {

			System.out.println("Digite o novo valor: ");
			produto.setValor(scan.nextDouble());
			scan.nextLine();
			System.out.println("Valor alterado com sucesso!");
			
		}else if (escolha == 3) {

			System.out.println("Digite a nova quantidade: ");
			produto.setEstoque(scan.nextInt());
			scan.nextLine();
			System.out.println("quantidade alterada com sucesso!");
		}
	}

	public static void apagarProduto() {
		visualizarProdutos();
		System.out.println("Selecione a opção que deseja Excluir: ");
		int escolha = scan.nextInt() - 1;
		scan.nextLine();
		if(escolha > produtos.size() || escolha < 0) {
			System.out.println("Selecione um valor válido!");
			return;
		}
		System.out.println("Deseja confirmar a exclusão do produto: \n 1 - Sim \n 2 - Não");
		Produto produto = produtos.get(escolha);
		System.out.printf("%s, valor: %.2f, estoque: %d\n", produto.getNome(), produto.getValor(), produto.getEstoque());
		int confirmacao = scan.nextInt();
		scan.nextLine();
		if(confirmacao == 1) {
			System.out.println("Exclusão realizada com sucesso!");
			produtos.remove(escolha);
		}else {
			System.out.println("Produto não excluido!");
		}
		
		
	}

	public static void visualizarProdutos() {
		System.out.println();
		System.out.println("---------------Lista produtos---------------");
		System.out.println();
		for (int i = 0; i < produtos.size(); i++) {
			Produto produto = produtos.get(i);
			System.out.printf("%d - %s, valor: %.2f, estoque: %d\n",i+1, produto.getNome(), produto.getValor(), produto.getEstoque());
		}
	}

	public static void cadastrarProduto() {
		Produto produto = new Produto();
		//pede nome do produto
		System.out.println("Digite o nome do produto:");
		produto.setNome(scan.nextLine());
		
		//Percorre a lista de produtos para validar se ja existe um igual cadastrado apartir do nome.
		for (Produto produtoFor : produtos) {
			if(produtoFor.getNome().equals(produto.getNome())) {
				System.out.println("Produto ja cadastrado!");
				return;
			}
		}	
		
		//Pede o preço para o usuario
		System.out.println("Digite o preço:");
		produto.setValor(scan.nextDouble());
		scan.nextLine();
		
		//Validar se o valor do produto é > que 0
		if(produto.getValor() < 0) {
			System.out.println("O valor do produto tem que ser maior que zero!");
			return;
		}
		
		//pede a quantidade de produtos para o usuario
		System.out.println("Digite a quantidade:");
		produto.setEstoque(scan.nextInt());
		scan.nextLine();
		
		//Valida a quantidade
		if(produto.getValor() < 0) {
			System.out.println("O estoque do produto tem que ser maior que zero!");
			return;
		}

		//Adiciona o produto na lista( que seria o controle de dados)
		produtos.add(produto);
		System.out.println("Produto adicionado com sucesso!");
	}
	
	

}
