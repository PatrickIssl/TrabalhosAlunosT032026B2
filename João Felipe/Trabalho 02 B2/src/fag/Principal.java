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
		System.out.println("--------------Biblioteca--------------");
		System.out.println("1 - Cadastrar Livro");
		System.out.println("2 - Vizualizar livros");
		System.out.println("3 - Editar Livro");
		System.out.println("4 - Apagar Livro");
		System.out.println("0 - Sair");
		escolhaUsuario = scan.nextInt();
		scan.nextLine();
		validarEscolha(escolhaUsuario);
		} while(escolhaUsuario != 0);
	}

	private static void validarEscolha(int escolhaUsuario) {
		switch(escolhaUsuario) {
			case 1: {
				cadastrarLivro();
				break;
			}
			case 2: {
				visualizarLivros();
				break;
			}
			case 3: {
				editarLivro();
				break;
			}
			case 4: {
				apagarLivro();
				break;
			}
			case 0: {
				System.out.println("Obrigado por utilizar nossa biblioteca!");
				break;
			}
			default: {
				System.out.println("Digite uma opção valida");
			}
		}
		
	}

	private static void apagarLivro() {
		visualizarLivros();
		System.out.println("Selecione a opcao que deseja excluir");
		int escolha = scan.nextInt() - 1;
		scan.nextLine();
		if(escolha >= livros.size() || escolha < 0) {
			System.out.println("Selecione um valor valido");
			return;
		}
		System.out.println("Deseja confirmar a exclusao do livro: \n 1 - Sim \n 2 - Não");
		Livro livro = livros.get(escolha);
		System.out.printf("Nome: %s \n", livro.getNome());
		int confirmacao = scan.nextInt();
		if(confirmacao == 1) {
			System.out.println("Exclusao realizada com sucesso");
			livros.remove(escolha);
		}else {
			System.out.println("Livro não exlcuido");
		}
	}

	private static void editarLivro() {
		visualizarLivros();
		System.out.println("Selecione o livro que deseja alterar");
		int escolha = scan.nextInt() - 1;
		scan.nextLine();
		if(escolha >= livros.size() || escolha < 0) {
			System.out.println("Escolha uma opcao valida");
			return;
		}
		Livro livro = livros.get(escolha);
		menuAlterarLivro(livro);
	}

	private static void menuAlterarLivro(Livro livro) {
		int escolha = 0;
		do {
			System.out.println("Selecione a opção que deseja alterar: ");
			System.out.println("1 - Nome");
			System.out.println("2 - Alugado");
			if(livro.isAlugado() == true) {
				System.out.println("3 - Dias");
			}
			System.out.println("0 - Sair");
			escolha = scan.nextInt();
			scan.nextLine();
			alterar(livro, escolha);
		}while(escolha != 0);
		
	}

	private static void alterar(Livro livro, int escolha) {
		if(escolha == 1) {
			System.out.println("Digite o novo nome: ");
			livro.setNome(scan.nextLine());
			System.out.println("Nome alterado com sucesso");
		}else if(escolha == 2) {
			System.out.println("Informe se está alugado ou não \n 1 - Sim \n 2 - Não");
			int status = scan.nextInt();
			scan.nextLine();
			if(status == 1) {
				livro.setAlugado(true);
				System.out.println("Status alterado com sucesso");
			}else if(status == 2) {
				livro.setAlugado(false);
				livro.setDias(0);
				System.out.println("Status alterado com sucesso");
			}else {
				System.out.println("Digite um valor valido");
			}
		}else if(escolha == 3) {
			System.out.println("Digite quantos dias o livro está alugado: ");
			int dias = scan.nextInt();
			scan.nextLine();
			livro.setDias(dias);
		}
		
	}

	private static void visualizarLivros() {
		System.out.println();
		System.out.println("--------------Livros--------------");
		System.out.println();
		for(int i = 0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			String situacao;
			if(livro.isAlugado() == true) {
				situacao = "Sim";
			}else {
				situacao = "Não";
			}
			System.out.printf("%d - Nome: %s, Alugado: %s, Dias Alugado: %d Dias \n", i+1, livro.getNome(), situacao, livro.getDias());
		}
	}
	
	private static void cadastrarLivro() {
		Livro livro = new Livro();
		System.out.println("Digite o nome do livro");
		livro.setNome(scan.nextLine());
		
		for(Livro livroFor : livros) {
			if(livroFor.getNome().equals(livro.getNome())) {
				System.out.println("Livro já cadastrado");
				return;
			}
		}
		System.out.println("O livro está alugado? \n 1 - Sim \n 2 - Não");
		int alugado = scan.nextInt();
		scan.nextLine();
		
		if(alugado == 1) {
			livro.setAlugado(true);
			System.out.println("Digite quantos dias o livro está alugado");
			int dias = scan.nextInt();
			scan.nextLine();
			if(dias <= 0) {
				System.out.println("Os dias alugados precisa ser maior que 0");
				return;
			}
			livro.setDias(dias);
		}else if(alugado == 2) {
			livro.setAlugado(false);
		}else {
			System.out.println("Digite um valor valido");
			return;
		}
		livros.add(livro);
		System.out.println("Livro cadastrado com sucesso!");
	}

}
