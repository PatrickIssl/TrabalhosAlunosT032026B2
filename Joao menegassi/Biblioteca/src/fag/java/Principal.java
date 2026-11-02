package fag.java;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fag.objetos.Livro;

public class Principal {

	static Scanner scan = new Scanner(System.in);
	static List<Livro> livros = new ArrayList<Livro>();

	public static void main(String[] args) {
		mostrarMenu();
	}

	public static void mostrarMenu() {
		int escolhaUsuario = 0;
		do {
			System.out.println("\n---------------Sistema Biblioteca---------------");
			System.out.println("Selecione uma opção a seguir: ");
			System.out.println("1 - Cadastrar Livro");
			System.out.println("2 - Visualizar Acervo");
			System.out.println("3 - Apagar Livro");
			System.out.println("4 - Alterar Livro");
			System.out.println("5 - Emprestar Livro");
			System.out.println("6 - Devolver Livro");
			System.out.println("0 - Sair");
			escolhaUsuario = scan.nextInt();
			scan.nextLine();
			validarEscolha(escolhaUsuario);
		} while (escolhaUsuario != 0);
	}

	public static void validarEscolha(int escolhaUsuario) {
		switch (escolhaUsuario) {
		case 1: {
			cadastrarLivro();
			break;
		}
		case 2: {
			visualizarLivros();
			break;
		}
		case 3: {
			apagarLivro();
			break;
		}
		case 4: {
			alterarLivro();
			break;
		}
		case 5: {
			emprestarLivro();
			break;
		}
		case 6: {
			devolverLivro();
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

	public static void cadastrarLivro() {
		Livro livro = new Livro();

		
		System.out.println("Digite o título do livro:");
		livro.setTitulo(scan.nextLine());

		
		for (Livro livroFor : livros) {
			if (livroFor.getTitulo().equalsIgnoreCase(livro.getTitulo())) {
				System.out.println("Livro já cadastrado!");
				return;
			}
		}

		
		System.out.println("Digite o autor:");
		livro.setAutor(scan.nextLine());

		
		System.out.println("Digite o ano de publicação:");
		livro.setAnoPublicacao(scan.nextInt());
		scan.nextLine();

	
		if (livro.getAnoPublicacao() <= 0) {
			System.out.println("O ano de publicação tem que ser maior que zero!");
			return;
		}

		
		System.out.println("Digite a quantidade de exemplares:");
		int exemplares = scan.nextInt();
		scan.nextLine();

	
		if (exemplares <= 0) {
			System.out.println("A quantidade de exemplares tem que ser maior que zero!");
			return;
		}
		livro.setExemplares(exemplares);
		livro.setDisponiveis(exemplares);

		
		livros.add(livro);
		System.out.println("Livro adicionado com sucesso!");
	}

	public static void visualizarLivros() {
		System.out.println();
		System.out.println("---------------Acervo da Biblioteca---------------");
		System.out.println();
		if (livros.isEmpty()) {
			System.out.println("Nenhum livro cadastrado.");
			return;
		}
		for (int i = 0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			System.out.printf("%d - %s, autor: %s, ano: %d, exemplares: %d, disponíveis: %d\n", i + 1,
					livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao(), livro.getExemplares(),
					livro.getDisponiveis());
		}
	}

	public static void apagarLivro() {
		visualizarLivros();
		if (livros.isEmpty()) {
			return;
		}
		System.out.println("Selecione o livro que deseja excluir: ");
		int escolha = scan.nextInt() - 1;
		scan.nextLine();
		if (escolha >= livros.size() || escolha < 0) {
			System.out.println("Selecione um valor válido!");
			return;
		}
		Livro livro = livros.get(escolha);
		if (livro.getDisponiveis() < livro.getExemplares()) {
			System.out.println("Não é possível excluir: existem exemplares emprestados!");
			return;
		}
		System.out.printf("%s, autor: %s, exemplares: %d\n", livro.getTitulo(), livro.getAutor(),
				livro.getExemplares());
		System.out.println("Deseja confirmar a exclusão do livro: \n 1 - Sim \n 2 - Não");
		int confirmacao = scan.nextInt();
		scan.nextLine();
		if (confirmacao == 1) {
			livros.remove(escolha);
			System.out.println("Exclusão realizada com sucesso!");
		} else {
			System.out.println("Livro não excluído!");
		}
	}

	public static void alterarLivro() {
		visualizarLivros();
		if (livros.isEmpty()) {
			return;
		}
		System.out.println("Selecione o livro que deseja alterar: ");
		int escolha = scan.nextInt() - 1;
		scan.nextLine();
		if (escolha >= livros.size() || escolha < 0) {
			System.out.println("Selecione um valor válido!");
			return;
		}
		Livro livro = livros.get(escolha);
		mostrarMenuAlterarLivro(livro);
	}

	public static void mostrarMenuAlterarLivro(Livro livro) {
		int escolha = 0;
		do {
			System.out.println("Selecione a opção que deseja alterar: ");
			System.out.println("1 - Título");
			System.out.println("2 - Autor");
			System.out.println("3 - Ano de publicação");
			System.out.println("4 - Quantidade de exemplares");
			System.out.println("0 - Sair");
			escolha = scan.nextInt();
			scan.nextLine();
			alterarValor(livro, escolha);
		} while (escolha != 0);
	}

	public static void alterarValor(Livro livro, int escolha) {
		if (escolha == 1) {
			System.out.println("Digite o novo título: ");
			livro.setTitulo(scan.nextLine());
			System.out.println("Título alterado com sucesso!");
		} else if (escolha == 2) {
			System.out.println("Digite o novo autor: ");
			livro.setAutor(scan.nextLine());
			System.out.println("Autor alterado com sucesso!");
		} else if (escolha == 3) {
			System.out.println("Digite o novo ano de publicação: ");
			livro.setAnoPublicacao(scan.nextInt());
			scan.nextLine();
			System.out.println("Ano alterado com sucesso!");
		} else if (escolha == 4) {
			System.out.println("Digite a nova quantidade de exemplares: ");
			int exemplares = scan.nextInt();
			scan.nextLine();
			int emprestados = livro.getExemplares() - livro.getDisponiveis();
			if (exemplares < emprestados) {
				System.out.println("Quantidade menor que o número de exemplares emprestados (" + emprestados + ")!");
				return;
			}
			livro.setExemplares(exemplares);
			System.out.println("Quantidade alterada com sucesso!");
		}
	}

	public static void emprestarLivro() {
		visualizarLivros();
		if (livros.isEmpty()) {
			return;
		}
		System.out.println("Selecione o livro que deseja emprestar: ");
		int escolha = scan.nextInt() - 1;
		scan.nextLine();
		if (escolha >= livros.size() || escolha < 0) {
			System.out.println("Selecione um valor válido!");
			return;
		}
		Livro livro = livros.get(escolha);
		if (livro.emprestar()) {
			System.out.println("Empréstimo realizado com sucesso!");
		} else {
			System.out.println("Não há exemplares disponíveis deste livro!");
		}
	}

	public static void devolverLivro() {
		visualizarLivros();
		if (livros.isEmpty()) {
			return;
		}
		System.out.println("Selecione o livro que deseja devolver: ");
		int escolha = scan.nextInt() - 1;
		scan.nextLine();
		if (escolha >= livros.size() || escolha < 0) {
			System.out.println("Selecione um valor válido!");
			return;
		}
		Livro livro = livros.get(escolha);
		if (livro.devolver()) {
			System.out.println("Devolução realizada com sucesso!");
		} else {
			System.out.println("Todos os exemplares deste livro já estão na biblioteca!");
		}
	}

}