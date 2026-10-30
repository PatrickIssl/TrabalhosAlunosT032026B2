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
		// pede o título do livro
		System.out.println("Digite o título do livro:");
		livro.setTitulo(scan.nextLine());

		// Percorre a lista de livros para validar se já existe um igual cadastrado a partir do título.
		for (Livro livroFor : livros) {
			if (livroFor.getTitulo().equalsIgnoreCase(livro.getTitulo())) {
				System.out.println("Livro já cadastrado!");
				return;
			}
		}

		// pede o autor
		System.out.println("Digite o autor:");
		livro.setAutor(scan.nextLine());

		// pede o ano de publicação
		System.out.println("Digite o ano de publicação:");
		livro.setAno(scan.nextInt());
		scan.nextLine();

		// Valida o ano
		if (livro.getAno() <= 0) {
			System.out.println("O ano tem que ser maior que zero!");
			return;
		}

		// pede a quantidade de exemplares
		System.out.println("Digite a quantidade de exemplares:");
		livro.setQuantidade(scan.nextInt());
		scan.nextLine();

		// Valida a quantidade
		if (livro.getQuantidade() <= 0) {
			System.out.println("A quantidade tem que ser maior que zero!");
			return;
		}

		// Adiciona o livro na lista (que seria o controle de dados)
		livros.add(livro);
		System.out.println("Livro cadastrado com sucesso!");
	}

	public static void visualizarLivros() {
		System.out.println();
		System.out.println("---------------Acervo da Biblioteca---------------");
		System.out.println();
		if (livros.isEmpty()) {
			System.out.println("Nenhum livro cadastrado!");
			return;
		}
		for (int i = 0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			System.out.printf("%d - %s, autor: %s, ano: %d, disponíveis: %d, emprestados: %d\n", i + 1,
					livro.getTitulo(), livro.getAutor(), livro.getAno(), livro.getQuantidade(),
					livro.getEmprestados());
		}
	}

	// Mostra a lista e pede para o usuário escolher um livro.
	// Retorna a posição do livro na lista ou -1 se a escolha for inválida.
	public static int selecionarLivro(String mensagem) {
		visualizarLivros();
		if (livros.isEmpty()) {
			return -1;
		}
		System.out.println(mensagem);
		int escolha = scan.nextInt() - 1;
		scan.nextLine();
		if (escolha >= livros.size() || escolha < 0) {
			System.out.println("Selecione um valor válido!");
			return -1;
		}
		return escolha;
	}

	public static void apagarLivro() {
		int escolha = selecionarLivro("Selecione o livro que deseja excluir: ");
		if (escolha == -1) {
			return;
		}
		Livro livro = livros.get(escolha);

		// Não deixa apagar um livro que está emprestado
		if (livro.getEmprestados() > 0) {
			System.out.println("Não é possível excluir! Existem exemplares emprestados.");
			return;
		}

		System.out.println("Deseja confirmar a exclusão do livro: \n 1 - Sim \n 2 - Não");
		System.out.printf("%s, autor: %s, ano: %d\n", livro.getTitulo(), livro.getAutor(), livro.getAno());
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
		int escolha = selecionarLivro("Selecione o livro que deseja alterar: ");
		if (escolha == -1) {
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
			System.out.println("3 - Ano");
			System.out.println("4 - Quantidade");
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
			System.out.println("Digite o novo ano: ");
			livro.setAno(scan.nextInt());
			scan.nextLine();
			System.out.println("Ano alterado com sucesso!");
		} else if (escolha == 4) {
			System.out.println("Digite a nova quantidade disponível: ");
			livro.setQuantidade(scan.nextInt());
			scan.nextLine();
			System.out.println("Quantidade alterada com sucesso!");
		}
	}

	public static void emprestarLivro() {
		int escolha = selecionarLivro("Selecione o livro que deseja emprestar: ");
		if (escolha == -1) {
			return;
		}
		Livro livro = livros.get(escolha);

		// Valida se ainda tem exemplar disponível
		if (livro.getQuantidade() <= 0) {
			System.out.println("Não há exemplares disponíveis deste livro!");
			return;
		}

		// tira um da quantidade disponível e soma um nos emprestados
		livro.setQuantidade(livro.getQuantidade() - 1);
		livro.setEmprestados(livro.getEmprestados() + 1);
		System.out.println("Livro \"" + livro.getTitulo() + "\" emprestado com sucesso!");
	}

	public static void devolverLivro() {
		int escolha = selecionarLivro("Selecione o livro que deseja devolver: ");
		if (escolha == -1) {
			return;
		}
		Livro livro = livros.get(escolha);

		// Valida se existe algum exemplar emprestado
		if (livro.getEmprestados() <= 0) {
			System.out.println("Nenhum exemplar deste livro está emprestado!");
			return;
		}

		// soma um na quantidade disponível e tira um dos emprestados
		livro.setQuantidade(livro.getQuantidade() + 1);
		livro.setEmprestados(livro.getEmprestados() - 1);
		System.out.println("Livro \"" + livro.getTitulo() + "\" devolvido com sucesso!");
	}

}
