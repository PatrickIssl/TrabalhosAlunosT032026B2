package fag;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fag.objetos.Livro;

public class Principal {

	static Scanner sc = new Scanner(System.in);
	static List<Livro> livros = new ArrayList<Livro>();

	public static void mostrarMenu() {
		int escolhaUsuario = 0;
		do {
			System.out.println("\n--- Sistema Biblioteca ---");
			System.out.println("Selecione uma opção a seguir: ");
			System.out.println("1 - Cadastrar Livro");
			System.out.println("2 - Listar Livros");
			System.out.println("3 - Alterar Livro");
			System.out.println("4 - Apagar Livro");
			System.out.println("0 - Sair");
			escolhaUsuario = sc.nextInt();
			sc.nextLine();

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
			listarLivros();
			break;
		}
		case 3: {
			alterarLivro();
			break;
		}
		case 4: {
			apagarLivro();
			break;
		}
		case 0: {
			System.out.println("Encerrado");
			break;
		}
		default:
			System.out.println("Opção invalida, digite outra opção");
		}
	}

	public static void cadastrarLivro() {
		Livro livro = new Livro();

		System.out.println("Digite o título do livro:");
		livro.setTitulo(sc.nextLine());

		for (Livro i : livros) {
			if (i.getTitulo().equals(livro.getTitulo())) {
				System.out.println("Livro já cadastrado!");
				return;
			}
		}

		System.out.println("Digite o autor:");
		livro.setAutor(sc.nextLine());

		System.out.println("Digite o ano de publicação:");
		livro.setAno(sc.nextInt());
		sc.nextLine();
		if (livro.getAno() <= 0) {
			System.out.println("O ano de publicação deve ser maior que zero!");
			return;
		}

		System.out.println("Digite a quantidade de exemplares:");
		livro.setQuant(sc.nextInt());
		sc.nextLine();
		if (livro.getQuant() < 0) {
			System.out.println("A quantidade não pode ser negativa!");
			return;
		}

		livros.add(livro);
		System.out.println("Livro cadastrado com sucesso!");
	}

	public static void listarLivros() {
		System.out.println("\nLista de livros:");
		if (livros.isEmpty()) {
			System.out.println("Nenhum livro cadastrado.");
			return;
		}
		for (int i = 0; i < livros.size(); i++) {
			exibirLivro(i + 1, livros.get(i));
		}
	}

	public static void alterarLivro() {
		listarLivros();
		if (livros.isEmpty()) {
			return;
		}
		System.out.println("Selecione o número do livro que deseja alterar:");
		int escolha = sc.nextInt() - 1;
		sc.nextLine();
		if (escolha >= livros.size() || escolha < 0) {
			System.out.println("Selecione um valor válido!");
			return;
		}
		mostrarMenuAlterarLivro(livros.get(escolha));
	}

	public static void mostrarMenuAlterarLivro(Livro livro) {
		int escolha = 0;
		do {
			System.out.println("\nSelecione o que deseja alterar: ");
			System.out.println("1 - Título");
			System.out.println("2 - Autor");
			System.out.println("3 - Ano de publicação");
			System.out.println("4 - Quantidade");
			System.out.println("0 - Voltar");
			escolha = sc.nextInt();
			sc.nextLine();
			alterarValor(livro, escolha);
		} while (escolha != 0);
	}

	public static void alterarValor(Livro livro, int escolha) {
		if (escolha == 1) {
			System.out.println("Digite o novo título: ");
			livro.setTitulo(sc.nextLine());
			System.out.println("Título alterado com sucesso!");
		} else if (escolha == 2) {
			System.out.println("Digite o novo autor: ");
			livro.setAutor(sc.nextLine());
			System.out.println("Autor alterado com sucesso!");
		} else if (escolha == 3) {
			System.out.println("Digite o novo ano de publicação: ");
			livro.setAno(sc.nextInt());
			sc.nextLine();
			System.out.println("Ano alterado com sucesso!");
		} else if (escolha == 4) {
			System.out.println("Digite a nova quantidade: ");
			livro.setQuant(sc.nextInt());
			sc.nextLine();
			System.out.println("Quantidade alterada com sucesso!");
		} else if (escolha != 0) {
			System.out.println("Digite uma opção válida!");
		}
	}

	public static void apagarLivro() {
		listarLivros();
		if (livros.isEmpty()) {
			return;
		}
		System.out.println("Selecione o número do livro que deseja excluir:");
		int escolha = sc.nextInt() - 1;
		sc.nextLine();
		if (escolha >= livros.size() || escolha < 0) {
			System.out.println("Selecione um valor válido!");
			return;
		}
		Livro livro = livros.get(escolha);
		exibirLivro(escolha + 1, livro);
		System.out.println("Deseja confirmar a exclusão do livro? \n 1 - Sim \n 2 - Não");
		int confirmacao = sc.nextInt();
		sc.nextLine();
		if (confirmacao == 1) {
			livros.remove(livro);
			System.out.println("Exclusão realizada com sucesso!");
		} else {
			System.out.println("Livro não excluído!");
		}
	}

	public static void exibirLivro(int numero, Livro livro) {
		System.out.printf("%d - %s, autor: %s, ano: %d, exemplares: %d\n", numero, livro.getTitulo(),
				livro.getAutor(), livro.getAno(), livro.getQuant());
	}

	public static void main(String[] args) {
		mostrarMenu();
	}
}