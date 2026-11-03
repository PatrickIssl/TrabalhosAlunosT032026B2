package fag;

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
			escolhaUsuario = lerInt();
			validarEscolha(escolhaUsuario);
		} while (escolhaUsuario != 0);
	}

	public static void validarEscolha(int escolhaUsuario) {
		switch (escolhaUsuario) {
		case 1:
			cadastrarLvro();
			break;
		case 2:
			visualizarLivros();
			break;
		case 3:
			apagarLivro();
			break;
		case 4:
			alterarLivro();
			break;
		case 5:
			emprestarLivro();
			break;
		case 6:
			devolverLivro();
			break;
		case 0:
			System.out.println("Obrigado por utilizar o sistema!");
			break;
		default:
			System.out.println("Digite uma opção válida!");
		}
	}

	
	public static int lerInt() {
		try {
			return Integer.parseInt(scan.nextLine().trim());
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	
	public static int escolherLivro(String mensagem) {
		if (livros.isEmpty()) {
			System.out.println("Nenhum livro cadastrado!");
			return -1;
		}
		visualizarLivros();
		System.out.println(mensagem);
		int escolha = lerInt() - 1;
		if (escolha >= livros.size() || escolha < 0) {
			System.out.println("Selecione um valor válido!");
			return -1;
		}
		return escolha;
	}

	public static void cadastrarLivro() {
		Livro livro = new Livro();

		System.out.println("Digite o título do livro:");
		String titulo = scan.nextLine().trim();
		if (titulo.isEmpty()) {
			System.out.println("O título não pode ser vazio!");
			return;
		}

		for (Livro livroFor : livros) {
			if (livroFor.getTitulo().equalsIgnoreCase(titulo)) {
				System.out.println("Livro já cadastrado!");
				return;
			}
		}
		livro.setTitulo(titulo);

		System.out.println("Digite o autor:");
		String autor = scan.nextLine().trim();
		if (autor.isEmpty()) {
			System.out.println("O autor não pode ser vazio!");
			return;
		}
		livro.setAutor(autor);

		System.out.println("Digite a quantidade de exemplares:");
		int quantidade = lerInt();
		if (quantidade <= 0) {
			System.out.println("A quantidade tem que ser maior que zero!");
			return;
		}
		livro = new Livro(livro.getTitulo(), livro.getAutor(), quantidade);

		livros.add(livro);
		System.out.println("Livro adicionado com sucesso!");
	}

	public static void visualizarLivros() {
		System.out.println();
		System.out.println("---------------Acervo da biblioteca---------------");
		System.out.println();
		if (livros.isEmpty()) {
			System.out.println("Nenhum livro cadastrado!");
			return;
		}
		for (int i = 0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			System.out.printf("%d - %s, autor: %s, disponíveis: %d de %d\n", i + 1, livro.getTitulo(),
					livro.getAutor(), livro.getQuantidadeDisponivel(), livro.getQuantidadeTotal());
		}
	}

	public static void apagarLivro() {
		int escolha = escolherLivro("Selecione o livro que deseja excluir: ");
		if (escolha == -1) {
			return;
		}
		Livro livro = livros.get(escolha);

		if (livro.getQuantidadeEmprestada() > 0) {
			System.out.println("Não é possível excluir: ainda há exemplares emprestados!");
			return;
		}

		System.out.println("Deseja confirmar a exclusão do livro: \n 1 - Sim \n 2 - Não");
		System.out.printf("%s, autor: %s, exemplares: %d\n", livro.getTitulo(), livro.getAutor(),
				livro.getQuantidadeTotal());
		int confirmacao = lerInt();
		if (confirmacao == 1) {
			livros.remove(escolha);
			System.out.println("Exclusão realizada com sucesso!");
		} else {
			System.out.println("Livro não excluído!");
		}
	}

	public static void alterarLivro() {
		int escolha = escolherLivro("Selecione o livro que deseja alterar: ");
		if (escolha == -1) {
			return;
		}
		mostrarMenuAlterarLivro(livros.get(escolha));
	}

	public static void mostrarMenuAlterarLivro(Livro livro) {
		int escolha = 0;
		do {
			System.out.println("Selecione a opção que deseja alterar: ");
			System.out.println("1 - Título");
			System.out.println("2 - Autor");
			System.out.println("3 - Quantidade de exemplares");
			System.out.println("0 - Sair");
			escolha = lerInt();
			alterarValor(livro, escolha);
		} while (escolha != 0);
	}

	public static void alterarValor(Livro livro, int escolha) {
		if (escolha == 1) {
			System.out.println("Digite o novo título: ");
			String titulo = scan.nextLine().trim();
			if (titulo.isEmpty()) {
				System.out.println("O título não pode ser vazio!");
				return;
			}
			livro.setTitulo(titulo);
			System.out.println("Título alterado com sucesso!");
		} else if (escolha == 2) {
			System.out.println("Digite o novo autor: ");
			String autor = scan.nextLine().trim();
			if (autor.isEmpty()) {
				System.out.println("O autor não pode ser vazio!");
				return;
			}
			livro.setAutor(autor);
			System.out.println("Autor alterado com sucesso!");
		} else if (escolha == 3) {
			System.out.println("Digite a nova quantidade: ");
			int quantidade = lerInt();
			if (quantidade <= 0) {
				System.out.println("A quantidade tem que ser maior que zero!");
				return;
			}
			if (livro.setQuantidadeTotal(quantidade)) {
				System.out.println("Quantidade alterada com sucesso!");
			} else {
				System.out.println("A quantidade não pode ser menor que os exemplares emprestados ("
						+ livro.getQuantidadeEmprestada() + ")!");
			}
		} else if (escolha != 0) {
			System.out.println("Digite uma opção válida!");
		}
	}

	public static void emprestarLivro() {
		int escolha = escolherLivro("Selecione o livro que deseja emprestar: ");
		if (escolha == -1) {
			return;
		}
		Livro livro = livros.get(escolha);
		if (livro.emprestar()) {
			System.out.println("Livro emprestado com sucesso!");
		} else {
			System.out.println("Nenhum exemplar disponível no momento!");
		}
	}

	public static void devolverLivro() {
		int escolha = escolherLivro("Selecione o livro que deseja devolver: ");
		if (escolha == -1) {
			return;
		}
		Livro livro = livros.get(escolha);
		if (livro.devolver()) {
			System.out.println("Livro devolvido com sucesso!");
		} else {
			System.out.println("Todos os exemplares já estão na biblioteca!");
		}
	}
}
