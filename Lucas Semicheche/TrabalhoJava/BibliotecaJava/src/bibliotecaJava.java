import java.lang.ProcessHandle.Info;


	
		import java.util.ArrayList;
		import java.util.Iterator;
		import java.util.List;
		import java.util.Scanner;
		
		import objeto.Livro;
		
	
	public class bibliotecaJava {
		
		static Scanner scan = new Scanner(System.in);
		static List<Livro> livros = new ArrayList<Livro>();
		
		public static void main(String[] args) {
		exibeMenu();
		}	

	public static void exibeMenu() {
		int escolhaUsuario = 0;
		do {
			System.out.println("\n-----Biblioteca FAG--------");
			System.out.println("Selecione uma opção a seguir: ");
			System.out.println("1 - Cadastrar um Livro");
			System.out.println("2 - Ver Meus Livros");
			System.out.println("3 - Editar Livro");
			System.out.println("4 - Consulta ISBN");
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
			verLivros();
			break;
		}
		case 3:{
			editarLivro();
			break;
		}
		case 4:{
			consultaIsbn();
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
		//pede nome do Livro
		System.out.println("Digite o nome do Livro");
		livro.setNome(scan.nextLine());
		
		//Percorre a lista de produtos para validar se ja existe um igual cadastrado apartir do nome.
		for (Livro livroFor : livros) {
			if(livroFor.getNome().equals(livro.getNome())) {
				System.out.println("Livro já cadastrado!");
				return;
			}
		}	
				//Pede nome do autor para o usuario
				System.out.println("Digite o nome do Autor:");
				livro.setAutor(scan.next());
				scan.nextLine();
				
				//pede a quantidade de livros para o cadastro
				System.out.println("Digite a quantidade:");
				livro.setQtd(scan.nextInt());
				scan.nextLine();
				
				//Validar se a qtd é > que 0
				if(livro.getQtd() < 0) {
					System.out.println("O valor do produto tem que ser maior que zero!");
					return;
				}
				
				//Cadastra o Codigo ISBN
				System.out.println("Digite o Codigo ISBN:");
				livro.setIsbn (scan.nextInt());
				scan.nextLine();
				
				//Valida se o codigo é válido
				if(livro.getIsbn() < 0) {
					System.out.println("O Codigo Informado esta incorreto!");
					return;
				}

				//Adiciona o produto na lista( que seria o controle de dados)
				livros.add(livro);
				System.out.println("Produto adicionado com sucesso!");
				}
		
		public static void verLivros() {
				System.out.println();
				System.out.println("----Lista livros FAG----");
				System.out.println();
				for (int i = 0; i < livros.size(); i++) {
					Livro livro = livros.get(i);
					System.out.printf("%d - %s - Autor: %s  Estoque: %d UN - Codigo ISBN: %d\n",i+1, livro.getNome(), livro.getAutor(), livro.getQtd(), livro.getIsbn());
				}
		}
		public static void editarLivro() {
			verLivros();
			System.out.println("Selecione o Livro que deseja alterar: ");
			int escolha = scan.nextInt() - 1;
			scan.nextLine();
			if(escolha > livros.size() || escolha < 0) {
				System.out.println("Selecione um valor válido!");
				return;
			}
			Livro livro = livros.get(escolha);
			mostrarMenuEditarLivro(livro);
		}
		public static void mostrarMenuEditarLivro(Livro livro) {
			int escolha = 0;
			do {
				System.out.println("Selecione a opção que deseja alterar: ");
				System.out.println("1 - Nome");
				System.out.println("2 - Autor");
				System.out.println("3 - Quantidade");
				System.out.println("4 - Código ISBN");
				System.out.println("0 - Sair");
				escolha = scan.nextInt();
				scan.nextLine();
				alterarlivroSel(livro, escolha);
			} while (escolha != 0);
		}
		
		public static void alterarlivroSel(Livro livro, int escolha) {
			if(escolha == 1) {
				System.out.println("Digite o novo Nome: ");
				livro.setNome(scan.nextLine());
				System.out.println("Nome alterado com sucesso!");
			}else if (escolha == 2) {

				System.out.println("Digite o novo Autor: ");
				livro.setAutor(scan.nextLine());
				System.out.println("Autor alterado com sucesso!");
				
			}else if (escolha == 3) {

				System.out.println("Digite a nova quantidade: ");
				livro.setQtd(scan.nextInt());
				scan.nextLine();
				System.out.println("quantidade alterada com sucesso!");
			
			}else if (escolha == 4) {

					System.out.println("Digite o novo Codigo ISBN: ");
					livro.setQtd(scan.nextInt());
					scan.nextLine();
					System.out.println("Código alterada com sucesso!");
					}	
			}
			
			public static void consultaIsbn() {
			Livro livroEncontrado = null;
			System.out.println("Digite Codigo ISBN para a busca: ");
			int cod = scan.nextInt();
			scan.nextLine();
			System.out.println();
			System.out.println("----Lista livros FAG----");
			System.out.println();
				for (int i = 0; i < livros.size(); i++) {
				Livro livro = livros.get(i);
					if (cod == livro.getIsbn()) {
						livroEncontrado = livro;
					}
				}
					if (livroEncontrado == null) {
					System.out.println("Código Não Cadastrado ou invalido!");
					} else {
					System.out.printf("%s - Autor: %s  Estoque: %d UN - Codigo ISBN: %d\n", livroEncontrado.getNome(), livroEncontrado.getAutor(), livroEncontrado.getQtd(), livroEncontrado.getIsbn());
					}
						
						
			}
		
}