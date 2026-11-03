package fag;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import fag.objetos.Livro;

public class PrincipalLivro {

	static Scanner scan = new Scanner(System.in);
	static List<Livro> livros = new ArrayList<Livro>();

	public static void main(String[] args) {
		mostrarMenu();
	}

	public static void mostrarMenu() {
		int opcao = 0;

		do {
			System.out.println("\n----------Selecione uma opção a seguir----------");
			System.out.println("1 - Cadastrar Livro");
			System.out.println("2 - Visualizar Biblioteca");
			System.out.println("3 - Apagar Livro");
			System.out.println("4 - Alterar Livro");
			System.out.println("0 - Sair");
			opcao = scan.nextInt();
			scan.nextLine();
			validarOpcao(opcao);

		} while (opcao != 0);

	}

	public static void validarOpcao(int opcao) {
		switch (opcao) {
		case 1: {
			cadastrarLivro();
			break;
		}
		case 2: {
			visualizarBiblioteca();
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
		case 0: {
			System.out.println("\nSistema finalizado! Volte Sempre!");
			break;
		}
		default:
			System.out.println("Opção inválida!");
		}

	}

	public static void cadastrarLivro() {
		Livro livro = new Livro();
		System.out.println("Digite o Título do livro:");
		livro.setTitulo(scan.nextLine());

		// validar se já existe cadastrado
		for (Livro livroFor : livros) {
			if (livroFor.getTitulo().equals(livro.getTitulo())) {
				System.out.println("Livro já cadastrado!");
				return;
			}

		}
		// informa dados do livro - autor, ano, quantidade
		System.out.println("Informe o Autor do livro: ");
		livro.setAutor(scan.nextLine());

		System.out.println("Informe o ano do livro: ");
		livro.setAno(scan.nextInt());
		scan.nextLine();
		// validar se o ano é > 0
		if (livro.getAno() <= 0) {
			System.out.println("O ano do livro tem que ser maior que zero!");
			return;
		}
		System.out.println("Informe a quantidade do livro: ");
		livro.setQuantidade(scan.nextInt());
		scan.nextLine();
		// validar se a quantidade é > 0
		if (livro.getQuantidade() < 0) {
			System.out.println("A quantidade do livro não pode ser negativa!");
			return;
		}
		// adiciona o livro na lista
		livros.add(livro);
		System.out.println("Livro adicionado com sucesso!");

	}

	public static void visualizarBiblioteca() {
		System.out.println("\n---------------Lista de livros---------------\n");
		for (int i = 0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			System.out.printf("%d - Título: %s, Autor: %s, Ano: %d, Quantidade: %d\n", i + 1, livro.getTitulo(),
					livro.getAutor(), livro.getAno(), livro.getQuantidade());
		}
	}

	public static void apagarLivro() {
		visualizarBiblioteca();
		System.out.println("Selecione o número do livro que deseja excluir: ");
		int escolha = scan.nextInt() - 1;
		scan.nextLine();

		if (escolha >= livros.size() || escolha < 0) {
			System.out.println("Selecione um valor válido!");
			return;
		}

		Livro livro = livros.get(escolha);
		System.out.printf("Livro a ser excluído \n Título: %s, Autor: %s, Ano: %d, Quantidade: %d\n", livro.getTitulo(),
				livro.getAutor(), livro.getAno(), livro.getQuantidade());
		System.out.println("Deseja confirmar a exclusão do livro? \n 1 - Sim \n 2 - Não");
		int confirmacao = scan.nextInt();
		scan.nextLine();

		if (confirmacao == 1) {
			livros.remove(escolha);
			System.out.println("Exclusão realizada com sucesso!");
			visualizarBiblioteca();
		} else {
			System.out.println("Livro não excluído!");
		}
	}

	public static void alterarLivro() {
		visualizarBiblioteca();
		System.out.println("Selecione o número do livro que deseja alterar: ");
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
		int opcao = 0;
		do {
			System.out.println("\nSelecione o que deseja alterar: ");
			System.out.println("1 - Título");
			System.out.println("2 - Autor");
			System.out.println("3 - Ano");
			System.out.println("4 - Quantidade");
			System.out.println("0 - Voltar");
			opcao = scan.nextInt();
			scan.nextLine();
			alterarValor(livro, opcao);
		} while (opcao != 0);
	}

	public static void alterarValor(Livro livro, int opcao) {
		switch (opcao) {
		case 1:
			System.out.println("Digite o novo título: ");
			livro.setTitulo(scan.nextLine());
			System.out.println("Título alterado com sucesso!");
			break;
		case 2:
			System.out.println("Digite o novo autor: ");
			livro.setAutor(scan.nextLine());
			System.out.println("Autor alterado com sucesso!");
			break;
		case 3:
			System.out.println("Digite o novo ano: ");
			int novoAno = scan.nextInt();
			scan.nextLine();
			if (novoAno > 0) {
				livro.setAno(novoAno);
				System.out.println("Ano alterado com sucesso!");
			} else {
				System.out.println("Ano tem que ser maior que zero!");
			}
			break;
		case 4:
			System.out.println("Digite a nova quantidade: ");
			int novaQuantidade = scan.nextInt();
			scan.nextLine();
			if (novaQuantidade >= 0) {
				livro.setQuantidade(novaQuantidade);
				System.out.println("Quantidade alterada com sucesso!");
			} else {
				System.out.println("Quantidade não pode ser negativa!");
			}
			break;
		case 0:
			System.out.println("Voltando ao menu principal!");
			break;
		default:
			System.out.println("Digite uma opção válida!");
		}
	}

}